/***********************************
 * Define constantes com os valores *
 * de cada instrução.               *
 * Ex.: addi = 001000               *
*************************************/

package main;

public class OpCode {
    //Valores do OpCode

    //Tipo R
    public final char [] R = { '0','0','0','0','0','0'};     //Instruções do tipo R

    //Aritmetica
    public final char [] addi = { '0','0','1','0','0','0'};  //Add Immediate
    public final char [] addiu = { '0','0','1','0','0','1'}; //Add Immediate Unsigned 
    
    //Transferencia de dados
    public final char [] lw = { '1','0','0','0','1','1'};    //Load Word
    public final char [] lh = { '1','0','0','0','0','1'};    //Load Halfword
    public final char [] lb = { '1','0','0','0','0','0'};    //Load Byte
    public final char [] sw = { '1','0','1','0','1','1'};    //Store Word
    public final char [] sh = { '1','0','1','0','0','1'};    //Store Halfword
    public final char [] sb = { '1','0','1','0','0','0'};    //Store Byte
    public final char [] lui = { '0','0','1','1','1','1'};   //Load Upper Immediate
    
    //Logica
    public final char [] andi = { '0','0','1','1','0','0'};  //And Immediate 
    public final char [] ori = { '0','0','1','1','0','1'};   //Or Immediate 
    public final char [] slti = { '0','0','1','0','1','0'};  //Set on Less Than Immediate

    //Desvio condicional
    public final char [] beq = { '0','0','0','1','0','0'};   //Branch on equal
    public final char [] bne = { '0','0','0','1','0','1'};   //Branch on not equal

    //Desvio incondicional - Tipo J
    public final char [] j = { '0','0','0','0','1','0'};     //Jump
    public final char [] jal = { '0','0','0','0','1','1'};   //Jump and link
}