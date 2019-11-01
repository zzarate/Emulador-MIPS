package instrucoes;

import java.util.Scanner;

import main.Memoria;
import registradores.OperacoesRegistradores;

class Syscall {
    
    void verifica (OperacoesRegistradores opReg, Memoria memoria){

        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 1 ) {
            //print integer ($a0 = integer to print)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%d\n", x);
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 4 ) {
            //print string ($a0 = address of null-terminated string to print)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 5 ) {
            //read integer ($v0 contains integer read)
            char[] vzero;
            int i = 31;
            int j = 0;
            vzero = new char[32];
            Scanner sc = new Scanner(System.in);  

            for(int k = 0; k < 32; k++){
                vzero[k] = '0';
            }
            int x = sc.nextInt();
            while(x > 0){
                j = x % 2;
                j = j + 48;
                vzero[i] = (char) j; 
                x = x / 2;
                i--;
            }
            opReg.setValorReg(2, vzero, memoria);
            sc.close();
    
        } 
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 8 ) {
            //read string
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 10 ) {
            //exit (terminate execution)
            //Imprimir os valores dos registradores e de toda a memoria

            //Imprime os valores dos registradores
            for (int i = 0; i < 31; i++) {
                int temp = (int)Long.parseLong(new String(opReg.getValorReg(i)), 2);
                System.out.print ("$" + i + "   ");
                System.out.println(String.format("0x%X", temp));
            }

            //Imprime os dados da memoria
            for (int k = 0; k < memoria.memory.length; k+=16) {
                int temp = memoria.memory[k];
                System.out.print ("Mem[");
                System.out.print (String.format("0x%X", temp));
                System.out.print ("] ");

                for (int i = 0; i < 16; i+=4) {
                    //Parte obscura para imprimir em hexa
                    String s = null;
                    s =Integer.toBinaryString((memoria.memory[k+0] & 0xFF) + 0x100).substring(1);
                    s= s+ Integer.toBinaryString((memoria.memory[k+1] & 0xFF) + 0x100).substring(1);
                    s= s+ Integer.toBinaryString((memoria.memory[k+2] & 0xFF) + 0x100).substring(1);
                    s= s+ Integer.toBinaryString((memoria.memory[k+3] & 0xFF) + 0x100).substring(1);
                    int palavraInt = (int)Long.parseLong(s, 2);
    
                    System.out.print (String.format("0x%X", palavraInt));
                    System.out.print (" ");
                }
                
            }

            System.exit(0); //terminado sem problemas
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 11 ) {
            //print character ($a0 = character to print,  	See note below table)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%c\n", x);
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 12 ) {
            //read character ($v0 contains character read)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 34 ) {
            //print integer in hexadecimal ($a0 = integer to print,Displayed value is 8 hexadecimal digits, left-padding with zeroes if necessary)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%x\n", x);
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 35 ) {
            //print integer in binary ($a0 = integer to print,Displayed value is 32 bits, left-padding with zeroes if necessary)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%c\n", x);
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 36 ) {
            //print integer as unsigned ($a0 = integer to print,Displayed as unsigned decimal value)
        }
    }
}
