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
        char carryIn = '0';
        char carryOut = '0';
        char[] result;
        result = new char[32];
    	for(int i = 31; i >= 0; i--){
            carryIn = carryOut;
            char and = and(num1[i], num2[i]);
            char or = or(num1[i], num2[i]);
            if(carryIn == '0'){
                if(and == '1' && or == '1'){
                    result[i] = '0';
                    carryOut = '1';
                }
                else
                    if(and == '0' && or == '0'){
                          result[i] = '0';
                          carryOut = '0'; 
                    }
                else{
                    result[i] = '1';
                    carryOut = '0';
                }
            }
            else{
                if(and == '1' && or == '1'){
                    result[i] = '1';
                    carryOut = '1';
                }
                else if(and == '0' && or == '0'){
                          result[i] = '1';
                          carryOut = '0'; 
                }
                else{
                    result[i] = '0';
                    carryOut = '1';
                }
            }
        }   
        return result;
    }

	private char or(char num1, char num2) {
		if(num1 == '0' && num2 == '0'){
            return zero;
        }
        else{
            return hum;
        }
    }

    private char and(char num1, char num2) {
        if(num1 == '1' && num2 == '1'){
            return hum;
        }
        else{
            return zero;
        }
    }

    //Subtração
    @Override
    public char[] sub(char[] num1, char[] num2) {
        int i = 31;
        char[] result;
        result = new char[32];
        while(num2[i] == '0'){
            i--;
        }
        i--;
        while( i >= 0){
            if(num2[i] == '1'){
                num2[i] = '0';
            }
            else{
                num2[i] = '1';
            }
            i--;
        }
        result = add(num1, num2);
        return result;
    }

    //Add Imediato
    @Override
    public char[] addi(char[] num1, char[] num2) {
        char[] numI;
        numI = new char[32];

        for(int i = 0; i < 32; i++){
            numI[i] = '0';
        }
        if(num2[0] == 1){
            for(int i = 15, j = 31; i > 0; i--, j--){
                numI[j] = num2[i];
            }
            numI[0] = '1';
        }
        else{
            for(int i = 15, j = 31; i > 0; i--, j--){
                numI[j] = num2[i];
            }
        }
        numI = add(num1, numI);
        return numI;
    }

    @Override
    public char[] addiu(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void mult(char[] num1, char[] num2, HILO hilo) {
        char[] mult; //multiplicando
        mult = new char[64];
        char[] prod;
        prod = new char[64];

        for(int i = 31, j = 63; i >= 0; i--, j--){ //aumentando num2 para mult de tamanho 64
            mult[j] = num2[i];
        }
        for(int j = 31; j >= 0; j--){ 
            mult[j] = '0';
        }
        for(int i = 0; i < 64; i++){
            prod[i] = '0';
        }
        for(int i = 0; i < 32; i++){
            if(num1[31] == 1){           // troquei 0 para 31 (to meio cansado, pode estar errado)
                add(mult, prod);            //      <---------------------------------------
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
        int j = 0;
        int[] hi, lo;
        int aux = 0;
        hi = new int[32];
        lo = new int[32];
        for(i = 0; i < 64; i++){
            hl[i] = '0';
        }

        num = numero1 % numero2;
        while(num > 0){
            j = num % 2;
            j = j + 48;    //tabela ascii +48
            hi[i] = (char) j; 
            num = num / 2;
            i--;
        }

        for(int k = 31; k >= 0; k--){
            aux = hi[k] + 48;
            hl[k] = (char) aux;
        }

        num = numero1 / numero2;
        i = 31;
        while(num > 0){
            j = num % 2;
            j = j + 48;    //tabela ascii +48
            lo[i] = (char) j;   
            num = num / 2;
            i--;
        }

        for(int k = 63, l = 31; l >= 0; k--, l--){
            aux = lo[l] + 48;
            hl[k] = (char) aux;
        }
        hilo.setHilo(hl);
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
    public char[] andi(char[] num1, char[] num2) {
	char[] result;
        result = new char[32];
	char[] num;
        num = new char[32];
	    
	for(int i = 0; i < 16; i++){
            num[i] = '0';
        } 
	for(int i = 16, k = 0; i < 32; i++, k++){
            num[i] = num2[k];
        }
	result[i] = and(num1, num);
        return result;
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
    public char[] ori(char[] num1, char[] num2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public char [] slt(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];
        result = sub(num1, num2);
        
        if(result[0] == '1'){
            return humArray;
        }
        else{
            return zeroArray;
        }
    }

    @Override
    public char[] slti(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];
        char[] num;
        num = new char[32];

        for(int i = 0; i < 16; i++){
            num[i] = '0';
        }
        for(int i = 31, k = 15; k >= 0; k--, i--){
            num[i] = num2[k];
        }
        result = sub(num1, num);
        
        if(result[0] == '1'){
            return humArray;
        }
        else{
            return zeroArray;
        }
    }

    @Override
    public char[] sll(char[] num1, char [] numArray) { 
        int num2 = Integer.parseInt(new String(numArray));
        int i;
        while(num2 > 0){
            for(i = 1; i < 32; i++){
                num1[i-1] = num1[i];
            }
            num1[31] = '0';
            num2--;
        }
        return num1;
    }

    public char[] srl(char[] num1, char [] numArray) {
        int num2 = Integer.parseInt(new String(numArray));
        int i;
        while(num2 > 0){
            for(i = 30; i >= 0; i--){
                num1[i+1] = num1[i];
            }
            num1[0] = '0';
            num2--;
        }
        return num1;
    }

    @Override
    public char[] sra(char[] num1, char[] numArray) {
        int num2 = Integer.parseInt(new String(numArray));
        int i;
        while(num2 > 0){
            for(i = 30; i >= 0; i--){
                num1[i+1] = num1[i];
            }
            num2--;
        }
        return num1;
    }
 
    @Override
    public char [] bne(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];
        result = sub(num1, num2);
        for(int i = 0; i < 32; i++){
            if(result[i] == 1){
                return humArray;
            }
        }
        return zeroArray;
    }

    @Override
    public char [] beq(char[] num1, char[] num2) {
        char[] result;
        result = new char[32];
        result = sub(num1, num2);
        for(int i = 0; i < 32; i++){
            if(result[i] == 1){
                return zeroArray;
            }
        }
        return humArray;
    }

}
