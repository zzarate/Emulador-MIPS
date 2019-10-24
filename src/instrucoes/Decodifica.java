package instrucoes;

import java.util.Arrays;

import alu.OpALU;
import registradores.OperacoesRegistradores;
public class Decodifica {

    private int rs = 0;
    private int rt = 0;
    private char[] valorImmI = new char [16];
    private char[] valorImmJ = new char [26];
	
    private InstrucoesR tipoR = new InstrucoesR();
    private OpALU alu = new OpALU();

    public void separaInstrucao (String instrucao, int PC, OperacoesRegistradores opReg){

        //Separa OpCode
        char opCode [];
        char vetInstrucao [];
        opCode = new char [6];
        vetInstrucao = new char [32];
        vetInstrucao = instrucao.toCharArray();
        
        for (int i = 0; i < 6; i++) {
            opCode [i] = vetInstrucao[i];
        }
        verificaInstrucao(opCode, vetInstrucao, PC, opReg);
        
        //Debug
        System.out.println ("OpCode: ");
        System.out.println (opCode);
        System.out.println ("");
    }


    void verificaInstrucao (char [] opCode, char [] vetInstrucao, int PC, OperacoesRegistradores opReg){
        OpCode instrucoes = new OpCode();

        //opCode tipo R
        if (Arrays.equals(opCode, instrucoes.R )) {
            System.out.println("Instrucao tipo R");
            tipoR.separaFunct(vetInstrucao, PC, opReg, alu);
        }
        
        //opCode Add immediate
        if (Arrays.equals(opCode, instrucoes.addi )) {
            salvaTipoI(vetInstrucao);//Salva valor do imediato
            opReg.setValorReg(rt, alu.addi(opReg.getValorReg(rs), valorImmI));
        }
        
        if (Arrays.equals(opCode, instrucoes.addiu )) {
            //opCode Add ediate Unsigned 
            System.out.println("Instrucao Add immediate Unsigned");
            salvaTipoI(vetInstrucao);//Salva valor do imediato
        }
        if (Arrays.equals(opCode, instrucoes.lw )) {
            //opCode Load Word
            System.out.println("Instrucao Load Word");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.lh )) {
            //opCode Load Halfword
            System.out.println("Instrucao Load Halfword");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.lb )) {
            //opCode Load Byte
            System.out.println("Instrucao Load Byte");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.sw )) {
            //opCode Store Word
            System.out.println("Instrucao Store Word");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.sh )) {
            //opCode Store Halfword
            System.out.println("Instrucao Store Halfword");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.sb )) {
            //opCode Move from low
            System.out.println("Instrucao Move from low");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.lui )) {
            //opCode And
            System.out.println("Instrucao And");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.andi )) {
            //opCode Or 
            System.out.println("Instrucao Or");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.ori )) {
            //opCode Set on Less Than 
            System.out.println("Instrucao Set on Less Than");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.slti )) {
            //opCode Shift left logical
            System.out.println("Instrucao Shift left logical");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.beq )) {
            //opCode Shift right logical
            System.out.println("Instrucao Shift right logical");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.bne )) {
            //opCode Branch on not equal
            System.out.println("Instrucao Branch on not equal");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.j )) {
            //opCode Jump
            System.out.println("Instrucao Jump");
            salvaTipoJ(vetInstrucao);
        }
        if (Arrays.equals(opCode, instrucoes.jal )) {
            //opCode Jump and link
            System.out.println("Instrucao Jump and link");
            salvaTipoJ(vetInstrucao);
        }
    }

    void salvaTipoJ(char [] vetInstrucao){

        //Reg imm
        for (int i = 6, j =0; i < 32; i++, j++) {
            valorImmJ [j] = vetInstrucao [i];
        }
    }

    void salvaTipoI (char [] vetInstrucao){
        char[] regDest = new char [5];

        //Reg rs
        for (int i = 6, j =0; i < 11; i++, j++) {
            regDest [j] = vetInstrucao[i];
        }
        rs= Integer.parseInt(new String(regDest));

        //Reg rt
        for (int i = 10, j =0; i < 16; i++, j++) {
            regDest [j] = vetInstrucao[i];
        }
        rt= Integer.parseInt(new String(regDest));
        
        //Reg imm
        for (int i = 15, j =0; i < 32; i++, j++) {
            valorImmI [j] = vetInstrucao[i];
        }
    }


}