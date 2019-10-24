package instrucoes;

import java.util.Arrays;

import alu.OpALU;
import registradores.HILO;
import registradores.OperacoesRegistradores;

public class InstrucoesR {

    private HILO hilo = new HILO();
    
    private int rs = 0;
    private int rt = 0;
    private int rd = 0;
    
    //private int newPC;


    void separaFunct (char [] vetInstrucao, int PC, OperacoesRegistradores opReg, OpALU alu){
        char [] funct;
        funct = new char [6];
        for (int i = 26, j =0; i <32; i++, j++) {
            funct [j] = vetInstrucao[i];
        }

        //verificar se SHAMT <--------------------------    
        verificaFunct(funct, vetInstrucao, PC, opReg, alu);
        //Debug
        System.out.println("Funct: ");
        System.out.println (funct);
    }

    void verificaShamt (char [] vetInstrucao,OperacoesRegistradores opReg, OpALU alu){
        char [] shamt = new char [6];
        int temp;

        for (int i = 20, j =0; i <26; i++, j++) {
            shamt [j] = vetInstrucao[i];
        }
        temp = Integer.parseInt(new String (shamt));
        if (temp != 0) {
            opReg.setValorReg(rd, alu.sll(opReg.getValorReg(rt), shamt));
        }
        

    }

    void verificaFunct (char [] funct, char [] vetInstrucao, int PC, OperacoesRegistradores opReg, OpALU alu ){
        Funct instrucoes = new Funct();

        //opCode Add
        if (Arrays.equals(funct, instrucoes.add )) {
            salvaRegTipoR(vetInstrucao);
            opReg.setValorReg(rd, alu.add(opReg.getValorReg(rs), opReg.getValorReg(rt)));
        }

        //opCode Sub
        if (Arrays.equals(funct, instrucoes.sub )) {
            salvaRegTipoR(vetInstrucao);
            opReg.setValorReg(rd, alu.sub(opReg.getValorReg(rs), opReg.getValorReg(rt)));
        }

        //opCode Multiply
        if (Arrays.equals(funct, instrucoes.mult )) {
            alu.mult(opReg.getValorReg(rs), opReg.getValorReg(rt), hilo);
        }

        //opCode Divide 
        if (Arrays.equals(funct, instrucoes.div )) {
            alu.div(opReg.getValorReg(rs), opReg.getValorReg(rt), hilo);
        }

        if (Arrays.equals(funct, instrucoes.mfhi )) {
            //opCode Move from high
            System.out.println("Instrucao Move from high");
        }
        if (Arrays.equals(funct, instrucoes.mflo )) {
            //opCode Move from low
            System.out.println("Instrucao Move from low");
        }
        if (Arrays.equals(funct, instrucoes.and )) {
            //opCode And
            System.out.println("Instrucao And");
        }
        if (Arrays.equals(funct, instrucoes.or )) {
            //opCode Or 
            System.out.println("Instrucao Or");
        }
        if (Arrays.equals(funct, instrucoes.slt )) {
            //opCode Set on Less Than 
            System.out.println("Instrucao Set on Less Than");
        }

        //opCode Shift left logical
        if (Arrays.equals(funct, instrucoes.sll)) {
            verificaShamt(vetInstrucao, opReg, alu);
        }

        if (Arrays.equals(funct, instrucoes.srl )) {
            //opCode Shift right logical
            System.out.println("Instrucao Shift right logical");
        }
        if (Arrays.equals(funct, instrucoes.sra )) {
            //opCode Shift right arithmetic
            System.out.println("Instrucao Shift right arithmetic");
        }
        if (Arrays.equals(funct, instrucoes.jr )) {
            //opCode Jump register
            System.out.println("Instrucao Jump register");

        }
        if (Arrays.equals(funct, instrucoes.syscall)) {
            //opCode Syscall
            System.out.println("Instrucao syscall");
            
        }
    }


    /* *******************************************************************
     *  Salva local do registrador que a instrucao vai utilizar          *
     *  Exemplo: ADD $t1 $t2 $t3 - 000000/01010/01011/01001/00000/100000 *
     *  RS = 01010 / Registrador 10/ $T2                                 *
     *  RT = 01011 / Registrador 11/ $T3                                 *
     *  RD = 01001 / Registrador 9 / $T1                                 *                       
     * *******************************************************************/

    void salvaRegTipoR(char[] instrucao){
        char [] regDest = new char [5];

        //Reg rs
        for (int i = 6, j =0; i <10; i++, j++) {
            regDest [j] = instrucao[i];
        }
        rs = Integer.parseInt(new String (regDest));

        //Reg rt
        for (int i = 10, j =0; i <15; i++, j++) {
            regDest [j] = instrucao[i];
        }
        rt = Integer.parseInt(new String (regDest));

        //Reg rd
        for (int i = 15, j =0; i <20; i++, j++) {
            regDest [j] = instrucao[i];
        }
        rd = Integer.parseInt(new String (regDest));
    }
}