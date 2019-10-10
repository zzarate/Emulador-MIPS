/***********************************
 * Define constantes com os valores *
 * de cada instrução.               *
 * Ex.: addi = 001000               *
*************************************/

package main;

public class Instrucoes {

    //Valores do OpCode

    //Tipo R
    public static final char [] R = { '0','0','0','0','0','0'};

    //Aritmetica
    


    //Alterar valor do conjunto
    
    public static final char [] addi = { '1','0','0','0','0','0'};
    public static final char [] addiu = { '1','0','0','0','0','0'};
    


    public static final char [] lw = { '1','0','0','0','0','0'};
    public static final char [] lh = { '1','0','0','0','0','0'};
    public static final char [] lb = { '1','0','0','0','0','0'};
    public static final char [] sw = { '1','0','0','0','0','0'};
    public static final char [] sh = { '1','0','0','0','0','0'};
    public static final char [] sb = { '1','0','0','0','0','0'};
    public static final char [] lui = { '1','0','0','0','0','0'};
    


    
    public static final char [] andi = { '1','0','0','0','0','0'};
    
    public static final char [] ori = { '1','0','0','0','0','0'};
    public static final char [] slt = { '1','0','0','0','0','0'};
    public static final char [] slti = { '1','0','0','0','0','0'};


    


    public static final char [] beq = { '1','0','0','0','0','0'};
    public static final char [] bne = { '1','0','0','0','0','0'};

    public static final char [] j = { '1','0','0','0','0','0'};
    
    public static final char [] jal = { '1','0','0','0','0','0'};

    //Valor do funct para instruções do tipo R

    public static final char [] add = { '1','0','0','0','0','0'};
    public static final char [] sub = { '1','0','0','0','0','0'};
    public static final char [] div = { '1','0','0','0','0','0'};
    public static final char [] mult = { '1','0','0','0','0','0'};

    public static final char [] mfhi = { '1','0','0','0','0','0'};
    public static final char [] mflo = { '1','0','0','0','0','0'};

    public static final char [] sll = { '1','0','0','0','0','0'};
    public static final char [] srl = { '1','0','0','0','0','0'};
    public static final char [] sra = { '1','0','0','0','0','0'};

    public static final char [] and = { '1','0','0','0','0','0'};
    public static final char [] or = { '1','0','0','0','0','0'};

    public static final char [] jr = { '1','0','0','0','0','0'};


    public static final char [] syscall = { '0','0','1','1','0','0'};



}