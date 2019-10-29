package alu;

import registradores.HILO;

public interface AluInterface {
	//Aritimeticas
    char[] add (char[] num1,char[] num2);
    char[] sub (char[] num1,char[] num2);
    char[] addi (char[] num1, char[] num2);
    void mult (char[] num1, char[] num2, HILO hilo);
    void div (char[] num1, char[] num2, HILO hilo);
    //Logica
	char [] or (char [] num1,char [] num2);
    char [] and (char [] num1,char [] num2);
    char [] slt (char[] num1,char[] num2);     //retornar um array de char

    //Deslocameno de bits
    char[] sll (char[] num1, char [] num2);
    char[] srl (char[] num1, char [] num2);
    char[] sra (char[] num1, char [] num2);
    //Desvio condicional
    char [] bne (char[] num1,char[] num2);
    char [] beq (char[] num1,char[] num2);
}
