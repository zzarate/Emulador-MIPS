package instrucoes;

import registradores.OperacoesRegistradores;

class Syscall {
    
    void verifica (OperacoesRegistradores opReg){

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
        } 
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 8 ) {
            //read string
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 10 ) {
            //exit (terminate execution)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 11 ) {
            //print character ($a0 = character to print,  	See note below table)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 12 ) {
            //read character ($v0 contains character read)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 34 ) {
            //print integer in hexadecimal ($a0 = integer to print,Displayed value is 8 hexadecimal digits, left-padding with zeroes if necessary)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 35 ) {
            //print integer in binary ($a0 = integer to print,Displayed value is 32 bits, left-padding with zeroes if necessary)
        }
        if (Integer.parseInt(new String (opReg.getValorReg(2))) == 36 ) {
            //print integer as unsigned ($a0 = integer to print,Displayed as unsigned decimal value)
        }
    }
}
