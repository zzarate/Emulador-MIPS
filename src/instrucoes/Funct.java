package instrucoes;

public class Funct {
    //Valor do funct para instruções do tipo R
    //Aritmetica - funct
    public final char [] add = { '1','0','0','0','0','0'};   //Add
    public final char [] sub = { '1','0','0','0','1','0'};   //Sub
    public final char [] mult = { '0','1','1','0','0','0'};  //Multiply
    public final char [] div = { '0','1','1','0','1','0'};   //Divide

    //Transferencia de dados - funct
    public final char [] mfhi = { '0','1','0','0','0','0'};  //Move from high
    public final char [] mflo = { '0','1','0','0','1','0'};  //Move from low
    
    //Logica - funct
    public final char [] and = { '1','0','0','1','0','0'};   //And
    public final char [] or = { '1','0','0','1','0','1'};    //Or
    public final char [] slt = { '1','0','1','0','1','0'};   //Set on Less Than

    //Deslocamento de bits - funct
    public final char [] sll = { '0','0','0','0','0','0'};   //Shift left logical
    public final char [] srl = { '0','0','0','0','1','0'};   //Shift right logical
    public final char [] sra = { '0','0','0','0','1','1'};   //Shift right arithmetic

    //Desvio incondiciona - funct
    public final char [] jr = { '0','0','1','0','0','0'};    //Jump register

    //Syscall
    public final char [] syscall = { '0','0','1','1','0','0'};  //Syscall
}