package main;

import java.util.Arrays;
public class Decodifica {
    private InstrucoesR tipoR = new InstrucoesR();

    void separaInstrucao (String instrucao){

        //Separa OpCode
        char opCode [];
        char vetInstrucao [];
        opCode = new char [6];
        vetInstrucao = new char [32];
        vetInstrucao = instrucao.toCharArray();
        
        for (int i = 0; i <6; i++) {
            opCode [i] = vetInstrucao[i];
        }
        verificaInstrucao(opCode, vetInstrucao);
        
        //Debug
        System.out.println ("OpCode: ");
        System.out.println (opCode);
        System.out.println ("");
    }

    void verificaInstrucao (char [] opCode, char [] vetInstrucao){
        OpCode instrucoes = new OpCode();

        if (Arrays.equals(opCode, instrucoes.R )) {
            //opCode tipo R
            System.out.println("Instrucao tipo R");
            tipoR.separaFunct(vetInstrucao);
        }
        if (Arrays.equals(opCode, instrucoes.addi )) {
            //opCode Add Immediate
            System.out.println("Instrucao Add Immediate");
        }
        if (Arrays.equals(opCode, instrucoes.addiu )) {
            //opCode Add Immediate Unsigned 
            System.out.println("Instrucao Add Immediate Unsigned");
        }
        if (Arrays.equals(opCode, instrucoes.lw )) {
            //opCode Load Word
            System.out.println("Instrucao Load Word");
        }
        if (Arrays.equals(opCode, instrucoes.lh )) {
            //opCode Load Halfword
            System.out.println("Instrucao Load Halfword");
        }
        if (Arrays.equals(opCode, instrucoes.lb )) {
            //opCode Load Byte
            System.out.println("Instrucao Load Byte");
        }
        if (Arrays.equals(opCode, instrucoes.sw )) {
            //opCode Store Word
            System.out.println("Instrucao Store Word");
        }
        if (Arrays.equals(opCode, instrucoes.sh )) {
            //opCode Store Halfword
            System.out.println("Instrucao Store Halfword");
        }
        if (Arrays.equals(opCode, instrucoes.sb )) {
            //opCode Move from low
            System.out.println("Instrucao Move from low");
        }
        if (Arrays.equals(opCode, instrucoes.lui )) {
            //opCode And
            System.out.println("Instrucao And");
        }
        if (Arrays.equals(opCode, instrucoes.andi )) {
            //opCode Or 
            System.out.println("Instrucao Or");
        }
        if (Arrays.equals(opCode, instrucoes.ori )) {
            //opCode Set on Less Than 
            System.out.println("Instrucao Set on Less Than");
        }
        if (Arrays.equals(opCode, instrucoes.slti )) {
            //opCode Shift left logical
            System.out.println("Instrucao Shift left logical");
        }
        if (Arrays.equals(opCode, instrucoes.beq )) {
            //opCode Shift right logical
            System.out.println("Instrucao Shift right logical");
        }
        if (Arrays.equals(opCode, instrucoes.bne )) {
            //opCode Branch on not equal
            System.out.println("Instrucao Branch on not equal");
        }
        if (Arrays.equals(opCode, instrucoes.j )) {
            //opCode Jump
            System.out.println("Instrucao Jump");
        }
        if (Arrays.equals(opCode, instrucoes.jal )) {
            //opCode Jump and link
            System.out.println("Instrucao Jump and link");
        }
    }

}