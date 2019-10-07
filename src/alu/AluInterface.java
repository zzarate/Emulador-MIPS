package alu;

public interface AluInterface {
	
    char[] add (char[] num1,char[] num2);
    char[] sub (char[] num1,char[] num2);
    char[] addi (char[] num1, int num2);
	char or (char num1,char num2);
    char and (char num1,char num2);
    char slt (char[] num1,char[] num2);
    char bne (char[] num1,char[] num2);
    char beq (char[] num1,char[] num2);
}
