package alu;

import registradores.HILO;

public interface AluInterface {
    //Aritimeticas
    char[] add (char[] num1,char[] num2);
    char[] sub (char[] num1,char[] num2);
    char[] addi (char[] num1, char[] num2);
    char[] addiu (char[] num1, char[] num2);   //duvida como funcina o U
    void mult (char[] num1, char[] num2, HILO hilo);
    void div (char[] num1, char[] num2, HILO hilo);
    //Logica
    char [] and (char [] num1,char [] num2);
    char [] andi (char [] num1,char [] num2);  //duvida: se faz so and os 16bit do imeidato ou 32bit do registrador
    char [] or (char [] num1,char [] num2);   
    char [] ori (char [] num1,char [] num2);   //mesma duvida q addi
    char [] slt (char[] num1,char[] num2);    
    char [] slti (char[] num1,char[] num2);
    //Deslocameno de bits
    char[] sll (char[] num1, char [] num2);
    char[] srl (char[] num1, char [] num2);
    char[] sra (char[] num1, char [] num2);
    //Desvio condicional
    char [] bne (char[] num1,char[] num2);
    char [] beq (char[] num1,char[] num2);
}
