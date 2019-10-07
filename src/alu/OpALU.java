package alu;

public class OpALU implements AluInterface {
    static final char zero = '0';
    static final char hum = '1';


    //Soma
    @Override
    public char[] add(char[] num1, char[] num2) {
        int carryin = 0;
        int carryout = 0;
        char[] result;
        result = new char[64];
    	for(int i = 0; i < 64; i++){
            carryin = carryout;
            int and = and(num1[i], num2[i]);
            int or = or(num1[i], num2[i]);
            if(carryin == 0){
                if(and == 1 && or == 1){
                    result[i] = 0;
                    carryout = 1;
                }
                else
                    if(and == 0 && or == 0){
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

    //Subtração
    @Override
    public char[] sub(char[] num1, char[] num2) {
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
        //num2 = addi(num2, 1); para somar 1
        result = add(num1, num2);
        return result;
    }

    //Add Imediato
    @Override
    public char[] addi(char[] num1, int num2) {

        int aux = 0;
        int numd;
        char[] numi;
        numd = num2;
        numi = new char[63];

        while(num2 > 0){
            

        }

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
        result = new char[63];
        result = sub(num1, num2);
        if(result[63] == 1){
            return hum;
        }
        else{
            return zero;
        }
    }

    @Override
    public char bne(char[] num1, char[] num2) {
        char[] result;
        int j = 0;
        result = new char[63];
        result = sub(num1, num2);
        for(int i = 0; i < 64; i++){
            if(result[i] == 1){
                return hum;
            }
            else{
                j++;
            }
        }
        if(j == 64){
            return zero;
        }
    }

    @Override
    public char beq(char[] num1, char[] num2) {
        char[] result;
        int j = 0;
        result = new char[63];
        result = sub(num1, num2);
        for(int i = 0; i < 64; i++){
            if(result[i] == 1){
                return zero;
            }
            else{
                j++;
            }
        }
        if(j == 64){
            return hum;
        }
    }

}
