package alu;

public class OpALU implements AluInterface {
    static final char zero = '0';
    static final char hum = '1';

    //Soma
    @Override
    public char[] add(char[] num1, char[] num2) {
        int carryIn = 0;
        int carryOut = 0;
        char[] result;
        result = new char[5];
    	for(int i = 0; i < 5; i++){
            carryIn = carryOut;
            int and = and(num1[i], num2[i]);
            int or = or(num1[i], num2[i]);
            if(carryIn == 0){
                if(and == 1 && or == 1){
                    result[i] = 0;
                    carryOut = 1;
                }
                else
                    if(and == 0 && or == 0){
                          result[i] = 0;
                          carryOut = 0; 
                    }
                else{
                    result[i] = 1;
                    carryOut = 0;
                }
            }
            else{
                if(and == 1 && or == 1){
                    result[i] = 1;
                    carryOut = 1;
                }
                else if(and == 0 && or == 0){
                          result[i] = 1;
                          carryOut = 0; 
                }
                else{
                    result[i] = 0;
                    carryOut = 1;
                }
            }
        }   
        return result;
    }

    //Subtração
    @Override
    public char[] sub(char[] num1, char[] num2) {
        char[] result;
        result = new char[5];

    	for(int i = 0; i < 5; i++){
            if(num2[i] == 0){
                num2[i] = 1;
            }
            else{
                num2[i] = 0;
            }
        }
        num2 = addi(num2, 1);
        result = add(num1, num2);
        return result;
    }

    //Add Imediato
    @Override
    public char[] addi(char[] num1, int num2) {

        int i = 4;
        int j = 4;
        int k = 15;
        int[] numI;
        char[] numC;
        numC = new char[5];
        numI = new int[16];

        while(k >= 0){
            numI[k] = 0;
            k--;
        }

        while(num2 > 0){
            numI[i] = num2 % 2;
            num2 = num2 / 2;
            i--;
        }
        for(i = 0; i < 5; i++){
            if(numI[i] == 0){
                numC[j] = 0;
                j--;
            }
            else{
                numC[j] = 1;
                j--;
            }
        }
        return numC;
    }

    @Override
    public char mult(char[] num1, char[] num2) {
        
        return 0;
    }

    @Override
	public char or(char num1, char num2) {
		if(num1 == 0 && num2 == 0){
            return zero;
        }
        else{
            return hum;
        }
    }

    @Override
    public char and(char num1, char num2) {
        if(num1 == 1 && num2 == 1){
            return hum;
        }
        else{
            return zero;
        }
    }

    @Override
    public char slt(char[] num1, char[] num2) {
        char[] result;
        result = new char[5];
        result = sub(num1, num2);
        
        if(result[4] == 1){
            return hum;
        }
        else{
            return zero;
        }
    }

    @Override
    public char[] sll(char[] num1, char num2) {
        int i = 4;
        int k;
        while(num2 > 0){
            for(k = 4; k > 0; k--){
                num1[i] = num1[i-1];
                i--;
            }
            num1[0] = 0;
            num2--;
        }
        return null;
    }

    public char[] srl(char[] num1, char num2) {
        int i = 0;
        int k;
        while(num2 > 0){
            for(k = 4; k > 0; k--){
                num1[i] = num1[i+1];
                i++;
            }
            num1[4] = 0;
            num2--;
        }
        return null;
    }
 
    @Override
    public char bne(char[] num1, char[] num2) {
        char[] result;
        result = new char[16];
        result = sub(num1, num2);
        for(int i = 0; i < 16; i++){
            if(result[i] == 1){
                return hum;
            }
        }
        return zero;
    }

    @Override
    public char beq(char[] num1, char[] num2) {
        char[] result;
        result = new char[16];
        result = sub(num1, num2);
        for(int i = 0; i < 16; i++){
            if(result[i] == 1){
                return zero;
            }
        }
        return hum;
    }
}
