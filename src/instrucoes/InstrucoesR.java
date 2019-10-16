package instrucoes;

import java.util.Arrays;

public class InstrucoesR {

    void separaFunct (char [] vetInstrucao){
        char [] funct;
        funct = new char [6];
        for (int i = 26, j =0; i <32; i++, j++) {
            funct [j] = vetInstrucao[i];
        }
        verificaFunct(funct);
        //Debug
        System.out.println("Funct: ");
        System.out.println (funct);
    }

    void verificaFunct (char [] funct){
        Funct instrucoes = new Funct();

        if (Arrays.equals(funct, instrucoes.add )) {
            //opCode Add
            System.out.println("Instrucao Add");
        }
        if (Arrays.equals(funct, instrucoes.sub )) {
            //opCode Sub
            System.out.println("Instrucao Sub");
        }
        if (Arrays.equals(funct, instrucoes.mult )) {
            //opCode Multiply
            System.out.println("Instrucao Multiply");
        }
        if (Arrays.equals(funct, instrucoes.div )) {
            //opCode Divide 
            System.out.println("Instrucao Divide");
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
        if (Arrays.equals(funct, instrucoes.sll)) {
            //opCode Shift left logical
            System.out.println("Instrucao Shift left logical");
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
            //opCode Jsyscall
            System.out.println("Instrucao syscall");
        }
    }

    void salvaRegTipoR(char[] instrucao){
        char[] regDest = new char [5];

        //Reg rs
        for (int i = 6, j =0; i <10; i++, j++) {
            regDest [j] = instrucao[i];
        }
        //setValorReg(Integer.parseInt(new String(regDest)));       <<<------

        //Reg rt
        for (int i = 10, j =0; i <15; i++, j++) {
            regDest [j] = instrucao[i];
        }

        //Reg rd
        for (int i = 15, j =0; i <20; i++, j++) {
            regDest [j] = instrucao[i];
        }
    }
}