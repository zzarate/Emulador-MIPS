package alu;

import registradores.HILO;

public class OpALU implements AluInterface {
    static final char zero = '0';
    static final char hum = '1';
    static final char [] humArray = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0', '0', '1'};
    static final char [] zeroArray = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0', '0', '0'};

    //Soma
    @Override
    public char[] add(char[] num1, char[] num2) {
        int carryIn = 0;
        int carryOut = 0;
        int tam = num1.length;  // tamanho do vetor
        char[] result;
        result = new char[tam];
    	for(int i = 0; i < tam; i++){
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

	private char or(char num1, char num2) {
		if(num1 == 0 && num2 == 0){
            return zero;
        }
        else{
            return hum;
        }
    }

    private char and(char num1, char num2) {
        if(num1 == 1 && num2 == 1){
            return hum;
        }
        else{
            return zero;
        }
    }

    //Subtração
    @Override
    public char[] sub(char[] num1, char[] num2) {
        int tam = num1.length;
        char[] result;
        result = new char[tam];
        char[] numI;
        numI = new char[16];
        for(int i = 0; i < 16; i++){
            numI[i] = 0;
        }
        numI[0] = 1;

    	for(int i = 0; i < tam; i++){
            if(num2[i] == 0){
                num2[i] = 1;
            }
            else{
                num2[i] = 0;
            }
        }
        num2 = addi(num2, numI);
        result = add(num1, num2);
        return result;
    }

    //Add Imediato
    @Override
    public char[] addi(char[] num1, char[] num2) {

        char[] numI;
        numI = new char[32];
        for(int i = 0; i < 32; i++){
            numI[i] = 0;
        }
        if(num2[15] == 1){
            for(int i = 0; i < 15; i++){
                numI[i] = num2[i];
            }
            numI[31] = 1;
        }
        else{
            for(int i = 0; i < 15; i++){
                numI[i] = num2[i];
            }
        }
        numI = add(num1, numI);
        return numI;
    }

    @Override
    public void mult(char[] num1, char[] num2, HILO hilo) {
        int i;
        char[] mult; //multiplicando
        mult = new char[64];
        char[] prod;
        prod = new char[64];
        int aux = num2.length;
        int tam = num1.length;

        for(i = 0; i < aux; i++){ //aumentando num2 para mult de tamanho 64
            mult[i] = num2[i];
        }
        for(i = aux; i < 64; i++){
            mult[i] = 0;
        }
        for(i = 0; i < 64; i++){
            prod[i] = 0;
        }
        for(i = 0; i < tam; i++){
            if(num1[0] == 1){
                add(mult, prod);            //                  <---------------------------------------
                sll(mult, humArray);
                srl(num1, humArray);
            }
            else{
                sll(mult, humArray);
                srl(num1, humArray);
            }
        }
        hilo.setHilo(prod);
    }

    @Override
    public void div(char[] num1, char[] num2, HILO hilo) {
        String n1 = String.copyValueOf(num1);
        String n2 = String.copyValueOf(num2);
        int numero1 = Integer.parseInt(n1, 2);
        int numero2 = Integer.parseInt(n2, 2);
        int num;
        char[] hl;
        hl = new char[64];
        int i = 31;
        int[] hi, lo;
        hi = new int[32];
        lo = new int[32];
        for(i = 0; i < 64; i++){
            hl[i] = 0;
        }

        num = numero1 % numero2;
        while(num > 0){
            hi[i] = num % 2;
            num = num / 2;
            i--;
        }

        for(int j = 31, k = 32; j >= 0; j--, k++){
                hl[k] = (char) hi[j];
        }

        num = numero1 / numero2;
        i = 31;
        while(num > 0){
            lo[i] = num % 2;
            num = num / 2;
            i--;
        }

        for(int j = 31, k = 0; j >= 0; j--, k++){
                hl[k] = (char) lo[j];
        }
        hilo.setHilo(hl);
    }

    @Override
    public char[] or(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];

        for(int i = 0; i < 32; i++){
            result[i] = or(num1[i], num2[i]);
        }
        return result;
    }

    @Override
    public char[] and(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];

        for(int i = 0; i < 32; i++){
            result[i] = and(num1[i], num2[i]);
        }
        return result;
    }

    @Override
    public char [] slt(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];
        result = sub(num1, num2);
        
        if(result[4] == 1){
            return humArray;
        }
        else{
            return zeroArray;
        }
    }

    @Override
    public char[] sll(char[] num1, char [] numArray) { 
        int num2 = Integer.parseInt(new String(numArray));
        int aux = num1.length; //ver o tamanho do vetor
        int i = aux - 1;
        int k;
        while(num2 > 0){
            for(k = 4; k > 0; k--){
                num1[i] = num1[i-1];
                i--;
            }
            num1[0] = 0;
            num2--;
        }
        return num1;
    }

    public char[] srl(char[] num1, char [] numArray) {
        int num2 = Integer.parseInt(new String(numArray));
        int aux = num1.length; //ver o tamanho do vetor
        int i = aux - 1;
        int k;
        while(num2 > 0){
            for(k = 4; k > 0; k--){
                num1[i] = num1[i+1];
                i++;
            }
            num1[31] = 0;
            num2--;
        }
        return num1;
    }

    @Override
    public char[] sra(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public char [] bne(char[] num1, char[] num2) {         //<------- Deve retornar um array de char
        char[] result;
        result = new char[16];
        result = sub(num1, num2);
        for(int i = 0; i < 16; i++){
            if(result[i] == 1){
                return humArray;
            }
        }
        return zeroArray;
    }

    @Override
    public char [] beq(char[] num1, char[] num2) {         //<------- Deve retornar um array de char
        char[] result;
        result = new char[16];
        result = sub(num1, num2);
        for(int i = 0; i < 16; i++){
            if(result[i] == 1){
                return zeroArray;
            }
        }
        return humArray;
    }

}
