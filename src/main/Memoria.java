package main;

import alu.OpALU;
import registradores.OperacoesRegistradores;

public class Memoria {
    public byte [] memory = new byte [4096 * 4];

    public final int minTextSection = 0x0000;   //0
    public final int maxTextSection = 0x0fff;   //4.095
    public final int minDataSection = 0x2000;   //8.192
    public final int maxDataSection = 0x2fff;   //12.287
    public final int minStack = 0x3000;         //12.288
    public final int maxStack = 0x3fff;         //16.383

    private int countMemText = minTextSection;

    public void salvaMemText (byte palavra){
        if (countMemText < maxTextSection){
            memory [countMemText] = palavra;

            countMemText++; //Contador para posição da memoria de texto
        }
    }

    private int countMemData = minDataSection;

    public void salvaMemData (byte palavra){
        if (countMemData < maxDataSection){
            memory [countMemData] = palavra;

            countMemData++; //Contador para posição da memoria de dados
        }
    }


    public void salvaPilha (byte palavra, OperacoesRegistradores opReg, OpALU alu){
        int sp = Integer.parseInt(new String(opReg.getValorReg(29)), 2);
        if (sp < minStack){
            memory [sp] = palavra;
        } else{
            System.out.println("Error: stack overflow.");
            System.exit(1);
        }
    }
}