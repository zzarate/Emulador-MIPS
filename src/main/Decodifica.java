package main;

public class Decodifica {

    void decodificaInstruc (char [] instucao){
        char [] opCode = new char [6];
        for (int i = 0; i < 6; i++) {
            opCode [i] = instucao [26+i];
        }

        for (int i = 0; i < 6; i++) {
            if (opCode [i] == 0){
                //Insturção tipo R
            }
        }
        

    }
}