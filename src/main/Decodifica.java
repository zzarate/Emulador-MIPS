package main;

public class Decodifica {
    char opCode [];
    char instrucao [];

    void decodificaInstrucao (String instrucao){
        opCode = new char [6];
        this.instrucao = new char [32];
        this.instrucao = instrucao.toCharArray();
        
        for (int i = 0; i <6; i++) {
            opCode [i] = this.instrucao[i];
        }
        System.out.println ("Instrucao: ");
        System.out.println (opCode);
        System.out.println ("");
    }
}