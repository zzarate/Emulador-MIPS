package alu;

public interface AluInterface {
	
	char Or (char num1,char num2);
    char And (char num1,char num2);
    char[] Add (char[] num1,char[] num2);
    char[] Sub (char[] num1,char[] num2);
    char slt (char[] num1,char[] num2);
    char bne (char num1,char num2);
    char beq (char num1,char num2);
}
