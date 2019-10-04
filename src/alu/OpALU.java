package alu;

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

    public char[] Add(char num1, char num2) {
        // TODO Auto-generated method stub
    	char [] a = null; //Remover
        return a;
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
