package main;

public class Memoria {
    final int minTextSection = 0x0000;   //0
    final int maxTextSection = 0x0fff;   //4.095
    final int minDataSection = 0x2000;   //8.192
    final int maxDataSection = 0x2fff;   //12.287
    final int minStack = 0x3000;         //12.288
    final int maxStack = 0x3fff;         //16.383

    private int countMemText = minTextSection;
    private int countMemData = minDataSection;

    public void salvaMemText (byte [] memory, byte instrucao){
        if (countMemText < maxTextSection){
            memory [countMemText] = instrucao;

            countMemText++; //Contador para posição da memoria de texto
        }
    }

    public void salvaMemData (byte [] memory, byte instrucao){
        if (countMemData < maxDataSection){
            memory [countMemData] = instrucao;

            countMemData++; //Contador para posição da memoria de texto
        }
    }
}