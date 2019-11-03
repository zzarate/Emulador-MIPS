package instrucoes;

import java.util.Scanner;

import alu.OpALU;
import main.Memoria;
import registradores.OperacoesRegistradores;

class Syscall {
    
    void verifica (OperacoesRegistradores opReg, Memoria memoria, Scanner sc, OpALU alu){

        String aux = new String(opReg.getValorReg(2));
        int tempk = (int)Long.parseLong(aux, 2);

        if (tempk == 1 ) { 
            //print integer ($a0 = integer to print)
            char[] y;
            y = new char[32];
            y = opReg.getValorReg(4);
            String n1 = String.copyValueOf(y);
            int x = (int) Long.parseLong(n1, 2);
            System.out.printf ("%d\n", x);
        }
        if (tempk == 4 ) {
            //print string ($a0 = address of null-terminated string to print)
            char[] y;
            y = new char[32];
            y = opReg.getValorReg(4);
            String n1 = String.copyValueOf(y);
            int x = (int) Long.parseLong(n1, 2);

            String temp = new String();
            temp = Integer.toBinaryString((memoria.memory[x] & 0xFF) + 0x100).substring(1);
            int tem = (int)Long.parseLong(temp, 2);

            while(tem != 0){   //0 na tabela ascii e null
                System.out.printf("%c", tem);
                temp = Integer.toBinaryString((memoria.memory[x+11] & 0xFF) + 0x100).substring(1);
                tem = (int)Long.parseLong(temp);
            }
        }
        if (tempk == 5 ) {
            //read integer ($v0 contains integer read)
            char[] vzero;
            int i = 31;
            int j = 0;
            vzero = new char[32];  
            char [] hum = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0', '0', '1'};

            for(int k = 0; k < 32; k++){
                vzero[k] = '0';
            }
            int x = sc.nextInt();
            if(x > 0){
                while(x > 0){
                    j = x % 2;
                    j = j + 48;
                    vzero[i] = (char) j; 
                    x = x / 2;
                    i--;
                }
            }
            else{
                x = x * (-1);
                while(x > 0){
                    j = x % 2;
                    j = j + 48;
                    vzero[i] = (char) j; 
                    x = x / 2;
                    i--;
                }
                for(int k = 0; k < 32; k++){
                    if(vzero[k] == '1'){
                        vzero[k] = '0';
                    }
                    else{
                        vzero[k] = '1';
                    }
                }
                vzero = alu.add(vzero, hum);
            }
            opReg.setValorReg(2, vzero, memoria);
        } 
        if (tempk == 8 ) {
            //read string
        }
        if (tempk == 10 ) {
            //exit (terminate execution)
            //Imprimir os valores dos registradores e de toda a memoria

            //Imprime os valores dos registradores
            for (int i = 0; i < 32; i++) {
                int temp = (int)Long.parseLong(new String(opReg.getValorReg(i)), 2);
                if (i<10) {
                    System.out.print ("$" + i + "	");
                }else{
                    System.out.print ("$" + i + "	");
                }
                System.out.println(String.format("0x%08x", temp));
            }

            //Imprime os dados da memoria
            for (int k = 0; k < memoria.memory.length; k+=16) {
                System.out.print ("Mem[");
                System.out.print (String.format("0x%08x", k));
                System.out.print ("]	");

                for (int i = 0; i < 16; i+=4) {
                    //Parte obscura para imprimir em hexa
                    String s = null;
                    s =Integer.toBinaryString((memoria.memory[k+i] & 0xFF) + 0x100).substring(1);
                    s= s+ Integer.toBinaryString((memoria.memory[k+i+1] & 0xFF) + 0x100).substring(1);
                    s= s+ Integer.toBinaryString((memoria.memory[k+i+2] & 0xFF) + 0x100).substring(1);
                    s= s+ Integer.toBinaryString((memoria.memory[k+i+3] & 0xFF) + 0x100).substring(1);
                    int palavraInt = (int)Long.parseLong(s, 2);
    
                    System.out.print (String.format("0x%08x", palavraInt));
                    System.out.print ("	");
                }
                System.out.println("");
                
            }

            System.exit(0); //terminado sem problemas
        }
        if (tempk == 11 ) {
            //print character ($a0 = character to print,  	See note below table)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%c\n", x);
        }
        if (tempk == 12 ) {
            //read character ($v0 contains character read)
            char[] vzero;
            int i = 31;
            int j = 0;
            vzero = new char[32]; 
            char c = sc.next().charAt(0);
            int x = (int) c;
            while(x > 0){
                j = x % 2;
                j = j + 48;
                vzero[i] = (char) j; 
                x = x / 2;
                i--;
            }
            opReg.setValorReg(2, vzero, memoria);
        }
        if (tempk == 34 ) {
            //print integer in hexadecimal ($a0 = integer to print,Displayed value is 8 hexadecimal digits, left-padding with zeroes if necessary)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%x\n", x);
        }
        if (tempk == 35 ) {
            //print integer in binary ($a0 = integer to print,Displayed value is 32 bits, left-padding with zeroes if necessary)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.printf ("%c\n", x);
        }
        if (tempk == 36 ) {
            //print integer as unsigned ($a0 = integer to print,Displayed as unsigned decimal value)
            int x;
            x = Integer.parseInt(new String (opReg.getValorReg(4)));
            System.out.println(Integer.toUnsignedString(x));
        }
    }
}
