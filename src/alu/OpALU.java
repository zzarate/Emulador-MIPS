package alu;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

public class OpALU implements AluInterface {

	public char Or(char num1, char num2) {
        // TODO Auto-generated method stub
		if(num1 == 0 && num2 == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public char And(char num1, char num2) {
        // TODO Auto-generated method stub
        if(num1 == 1 && num2 == 1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public char[] Add(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        int carryin = 0;
        int carryout = 0;
        char[] result;
        result = new char[63];
    	for(int i = 0; i < 64; i++){
            int and = And(num1[i], num2[i]);
            int or = Or(num1[i], num2[i]);
            if(carryin == 0){
                if(and == 1 && or == 1){
                    result[i] = 0;
                    carryout = 1;
                }
                else if(and == 0 && or == 0){
                          result[i] = 0;
                          carryout = 0; 
                }
                else{
                    result[i] = 1;
                    carryout = 0;
                }
            }
            else{
                if(and == 1 && or == 1){
                    result[i] = 1;
                    carryout = 1;
                }
                else if(and == 0 && or == 0){
                          result[i] = 1;
                          carryout = 0; 
                }
                else{
                    result[i] = 0;
                    carryout = 1;
                }
            }
        }   
        return result;
    }

    public char[] Sub(char num1, char num2) {
        // TODO Auto-generated method stub
    	char [] a = null; //Remover
        return a;
    }

    public char slt(char num1, char num2) {
        // TODO Auto-generated method stub
        return 0;
    }

    public char bne(char num1, char num2) {
        // TODO Auto-generated method stub
        return 0;
    }

    public char beq(char num1, char num2) {
        // TODO Auto-generated method stub
        return 0;
    }
}
