package alu;

public interface AluInterface {
	//Aritimeticas
    char[] add (char[] num1,char[] num2);
    char[] sub (char[] num1,char[] num2);
    char[] addi (char[] num1, int num2);
    char mult (char[] num1, char[] num2);
    //Logica
	char or (char num1,char num2);
    char and (char num1,char num2);
    char slt (char[] num1,char[] num2);
    //Deslocameno de bits
    char[] sll (char[] num1, char num2);
    char[] srl (char[] num1, char num2);
    //Desvio condicional
    char bne (char[] num1,char[] num2);
    char beq (char[] num1,char[] num2);
    //Desvio incondicional
}
