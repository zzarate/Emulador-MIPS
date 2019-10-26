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
            tipoR.separaFunct(vetInstrucao, PC, opReg, alu);
        }
        
        //opCode Add immediate
        if (Arrays.equals(opCode, instrucoes.addi )) {               //<---- Verificar
            salvaTipoI(vetInstrucao);//Salva valor do imediato
            opReg.setValorReg(rt, alu.addi(opReg.getValorReg(rs), valorImmI));
        }
        
        if (Arrays.equals(opCode, instrucoes.addiu )) {
            salvaTipoI(vetInstrucao);//Salva valor do imediato
        }
        if (Arrays.equals(opCode, instrucoes.lw )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.lh )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.lb )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.sw )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.sh )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.sb )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.lui )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.andi )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.ori )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.slti )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.beq )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        if (Arrays.equals(opCode, instrucoes.bne )) {
            //opCode Branch on not equal
            System.out.println("Instrucao Branch on not equal");
            salvaTipoI(vetInstrucao);//Salva valor no imediato
        }
        
        //opCode Jump
        if (Arrays.equals(opCode, instrucoes.j )) {
            salvaTipoJ(vetInstrucao);

            char [] auxPC = new char [32];
            char [] newPC = new char [32];

            salvaTipoJ(vetInstrucao);
            auxPC = ("" + PC+4).toCharArray();      //Atualiza o PC para a proxima instrução

            for (int i = 0; i < 3; i++) {       //Armazena os 4 bits mais significativos do PC
                newPC[i] = auxPC[i];
            }
            for (int i = 3, j=0 ; i < 29; i++, j++) {       //Rcebe os 26 bits do imediato
                newPC[i] = valorImmJ [j];
            }
            for (int i = 29; i < 31; i++) {     //Adiciona zero nos dois bits menos significativo
                newPC [i] = 0;
            }

            opReg.setPC(Integer.parseInt(new String(newPC)));   //Atualiza o Proximo valor do PC
        }
        
        //opCode Jump and link
        if (Arrays.equals(opCode, instrucoes.jal )) {
            char [] auxPC = new char [32];
            char [] newPC = new char [32];

            salvaTipoJ(vetInstrucao);
            auxPC = ("" + PC+4).toCharArray();  //Atualiza o PC para a proxima instrução
            opReg.setValorReg(31, auxPC);       //Guarda o valor do proximo PC no $RA

            for (int i = 0; i < 3; i++) {       //Armazena os 4 bits mais significativos do PC
                newPC[i] = auxPC[i];
            }
            for (int i = 3, j=0 ; i < 29; i++, j++) {       //Receber os 26 bits do imediato em sequencia
                newPC[i] = valorImmJ [j];
            }
            for (int i = 29; i < 31; i++) {     //Adiciona zero nos dois bits menos significativos
                newPC [i] = 0;
            }

            opReg.setPC(Integer.parseInt(new String(newPC)));   //Atualiza o Proximo valor do PC
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