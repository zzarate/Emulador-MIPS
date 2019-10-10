/***********************************
 * Define constantes com os valores *
 * de cada instrução.               *
 * Ex.: addi = 001000               *
*************************************/

package main;

public class Instrucoes {

    //Valores do OpCode

    //Tipo R
    public static final char [] R = { '0','0','0','0','0','0'};     //Instruções do tipo R

    //Aritmetica
    public static final char [] addi = { '0','0','1','0','0','0'};  //Add Immediate
    public static final char [] addiu = { '0','0','1','0','0','1'}; //Add Immediate Unsigned 
    
    //Transferencia de dados
    public static final char [] lw = { '1','0','0','0','1','1'};    //Load Word
    public static final char [] lh = { '1','0','0','0','0','1'};    //Load Halfword
    public static final char [] lb = { '1','0','0','0','0','0'};    //Load Byte
    public static final char [] sw = { '1','0','1','0','1','1'};    //Store Word
    public static final char [] sh = { '1','0','1','0','0','1'};    //Store Halfword
    public static final char [] sb = { '1','0','1','0','0','0'};    //Store Byte
    public static final char [] lui = { '0','0','1','1','1','1'};   //Load Upper Immediate
    
    //Logica
    public static final char [] andi = { '0','0','1','1','0','0'};  //And Immediate 
    public static final char [] ori = { '0','0','1','1','0','1'};   //Or Immediate 
    public static final char [] slti = { '0','0','1','0','1','0'};  //Set on Less Than Immediate

    //Desvio condicional
    public static final char [] beq = { '0','0','0','1','0','0'};   //Branch on equal
    public static final char [] bne = { '0','0','0','1','0','1'};   //Branch on not equal

    //Desvio incondicional - Tipo J
    public static final char [] j = { '0','0','0','0','1','0'};     //Jump
    public static final char [] jal = { '0','0','0','0','1','1'};   //Jump and link

    //---------------------------------------------------------------------------------------//

    //Valor do funct para instruções do tipo R
    //Aritmetica - funct
    public static final char [] add = { '1','0','0','0','0','0'};   //Add
    public static final char [] sub = { '1','0','0','0','1','0'};   //Sub
    public static final char [] mult = { '0','1','1','0','0','0'};  //Multiply
    public static final char [] div = { '0','1','1','0','1','0'};   //Divide

    //Transferencia de dados - funct
    public static final char [] mfhi = { '0','1','0','0','0','0'};  //Move from high
    public static final char [] mflo = { '0','1','0','0','1','0'};  //Move from low
    
    //Logica - funct
    public static final char [] and = { '1','0','0','1','0','0'};   //And
    public static final char [] or = { '1','0','0','1','0','1'};    //Or
    public static final char [] slt = { '1','0','1','0','1','0'};   //Set on Less Than

    //Deslocamento de bits- funct
    public static final char [] sll = { '0','0','0','0','0','0'};   //Shift left logical
    public static final char [] srl = { '0','0','0','0','1','0'};   //Shift right logical
    public static final char [] sra = { '0','0','0','0','1','1'};   //Shift right arithmetic

    //Desvio incondiciona- - funct
    public static final char [] jr = { '0','0','1','0','0','0'};    //Jump register

    //Syscall
    public static final char [] syscall = { '0','0','1','1','0','0'};  //--Valor correto* 



}