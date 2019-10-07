package alu;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Add;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

import jdk.internal.loader.AbstractClassLoaderValue.Sub;

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
            carryin = carryout;
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

    public char[] Sub(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        char[] result;
        result = new char[63];

    	for(int i = 0; i < 64; i++){
            if(num2[i] == 0){
                num2[i] = 1;
            }
            else{
                num2[i] = 0;
            }
        }
        //num2 = Addi(num2, 1); para somar 1
        result = Add(num1, num2);
        return result;
    }

    public char slt(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        char[] result;
        result = new char[63];
        result = Sub(num1, num2);
        if(result[63] == 1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public char bne(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        char[] result;
        int j = 0;
        result = new char[63];
        result = Sub(num1, num2);
        for(int i = 0; i < 64; i++){
            if(result[i] == 1){
                return 1;
            }
            else{
                j++;
            }
        }
        if(j == 64){
            return 0;
        }
    }

    public char beq(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        char[] result;
        int j = 0;
        result = new char[63];
        result = Sub(num1, num2);
        for(int i = 0; i < 64; i++){
            if(result[i] == 1){
                return 0;
            }
            else{
                j++;
            }
        }
        if(j == 64){
            return 1;
        }
    }

    public char[] Addi(char[] num1, int num2) {
        int aux = 0;
        int numd;
        char[] numi;
        numd = num2;
        numi = new char[63];

        while(num2 > 0){
            

        }

    }
}
