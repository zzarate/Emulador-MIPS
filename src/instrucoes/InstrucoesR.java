package instrucoes;

import java.util.Arrays;

import alu.OpALU;
import main.Memoria;
import registradores.HILO;
import registradores.OperacoesRegistradores;

public class InstrucoesR {

    private Syscall syscall = new Syscall();
    
    private int rs = 0;
    private int rt = 0;
    private int rd = 0;
    private char [] shamt = new char [6];
    


    void separaFunct (char [] vetInstrucao, int PC, OperacoesRegistradores opReg, OpALU alu, HILO hilo, Memoria memoria){
        char [] funct;
        funct = new char [6];
        for (int i = 26, j =0; i <32; i++, j++) {
            funct [j] = vetInstrucao[i];
        }
  
        verificaFunct(funct, vetInstrucao, PC, opReg, alu, hilo, memoria);
        //Debug
        System.out.println("Funct: ");
        System.out.println (funct);
    }

    void verificaShamt (char [] vetInstrucao,OperacoesRegistradores opReg, OpALU alu){
        for (int i = 20, j =0; i <26; i++, j++) {
            shamt [j] = vetInstrucao[i];
        }
        
    }

    void verificaFunct (char [] funct, char [] vetInstrucao, int PC, OperacoesRegistradores opReg, OpALU alu, HILO hilo, Memoria memoria ){
        Funct instrucoes = new Funct();

        //Add
        if (Arrays.equals(funct, instrucoes.add )) {
            salvaRegTipoR(vetInstrucao);
            opReg.setValorReg(rd, alu.add(opReg.getValorReg(rs), opReg.getValorReg(rt)), memoria);
        }

        //Sub
        if (Arrays.equals(funct, instrucoes.sub )) {
            salvaRegTipoR(vetInstrucao);
            opReg.setValorReg(rd, alu.sub(opReg.getValorReg(rs), opReg.getValorReg(rt)), memoria);
        }

        //Multiply
        if (Arrays.equals(funct, instrucoes.mult )) {
            alu.mult(opReg.getValorReg(rs), opReg.getValorReg(rt), hilo);
        }

        //Divide 
        if (Arrays.equals(funct, instrucoes.div )) {
            alu.div(opReg.getValorReg(rs), opReg.getValorReg(rt), hilo);
        }

        //opCode Move from high
        if (Arrays.equals(funct, instrucoes.mfhi )) {
            opReg.setValorReg(rd, hilo.getHI(), memoria);
        }

        //opCode Move from low
        if (Arrays.equals(funct, instrucoes.mflo )) {
            opReg.setValorReg(rd, hilo.getLO(), memoria);
        }

        //AND
        if (Arrays.equals(funct, instrucoes.and )) {
            opReg.setValorReg(rd, alu.and(opReg.getValorReg(rs), opReg.getValorReg(rt)), memoria);
        }

        //OR
        if (Arrays.equals(funct, instrucoes.or )) {
            opReg.setValorReg(rd, alu.or(opReg.getValorReg(rs), opReg.getValorReg(rt)), memoria);
        }

        //Set on Less Than
        if (Arrays.equals(funct, instrucoes.slt )) {
            opReg.setValorReg(rd, alu.slt(opReg.getValorReg(rs), opReg.getValorReg(rt)), memoria);
        }

        //Shift left logical
        if (Arrays.equals(funct, instrucoes.sll)) {
            verificaShamt(vetInstrucao, opReg, alu);
            opReg.setValorReg(rd, alu.sll(opReg.getValorReg(rs), shamt), memoria);
        }

        //Shift right logical
        if (Arrays.equals(funct, instrucoes.srl )) {
            verificaShamt(vetInstrucao, opReg, alu);
            opReg.setValorReg(rd, alu.srl(opReg.getValorReg(rs), shamt), memoria);
        }

        //Shift right arithmetic
        if (Arrays.equals(funct, instrucoes.sra )) {
            opReg.setValorReg(rd, alu.sra(opReg.getValorReg(rs), shamt), memoria);
        }
        
        //Jump register
        if (Arrays.equals(funct, instrucoes.jr )) {
            opReg.setPC(Integer.parseInt(new String (opReg.getValorReg(rs))));
        }

        //Syscall
        if (Arrays.equals(funct, instrucoes.syscall)) {
            syscall.verifica(opReg, memoria);
            
        }
    }

     /**
      *  Salva local do registrador que a instrucao vai utilizar
      *  Exemplo: ADD $t1 $t2 $t3 - 000000/01010/01011/01001/00000/100000 
      *  RS = 01010 / Registrador 10/ $T2                                 
      *  RT = 01011 / Registrador 11/ $T3                              
      *  RD = 01001 / Registrador 9 / $T1
      * 
      * @param instrucao instrucao para receber o destino dos registradores
      */
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