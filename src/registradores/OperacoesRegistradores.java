package registradores;

public class OperacoesRegistradores{

    private Registradores registradores = new Registradores();

    public void setPC (int newPC){
        registradores.PC= newPC;
    }

    public int getPC (){
        return registradores.PC;
    }

    /**
     * Extende o tamanho do array de retorno para 
     * garantir que ele tenha 32 bits
     * 
     * @param valor     valor de retorno com tamanho < 32
     * @return          valor enviado com 32 bits de tamanho
     */
    private char [] fillArray (char [] valor){
        int tamVet = valor.length;
        char [] result = new char [32];

        if (tamVet < 32) {
            for (int i = tamVet; i < 32; i++) {
                result[i] = '0';
            }
        }
        return result;
    }

    public void setValorReg(int enderecoReg, char [] valor ){
        //Registrador $zero     0
        if (enderecoReg == 0 ) {
        }
        
        //Registrador $AT       1
        if (enderecoReg == 1 ) {
            registradores.$AT=registradores.$zero;
            registradores.$AT=valor;
        }
        
        //Registrador $V0       2
        if (enderecoReg == 2 ) {
            registradores.$V0=registradores.$zero;
            registradores.$V0=valor;
        } 

        //Registrador $V1       3
        if (enderecoReg == 3 ) {
            registradores.$V1=registradores.$zero;
            registradores.$V1=valor;
        }

        //Registrador $A0       4
        if (enderecoReg == 4 ) {
            registradores.$A0=registradores.$zero;
            registradores.$A0=valor;
        }
        
        //Registrador $A1       5
        if (enderecoReg == 5 ) {
            registradores.$A1=registradores.$zero;
            registradores.$A1=valor;
        }
        
        //Registrador $A2       6
        if (enderecoReg == 6 ) {
            registradores.$A2=registradores.$zero;
            registradores.$A2=valor;
        }
        
        //Registrador $A3       7
        if (enderecoReg == 7 ) {
            registradores.$A3=registradores.$zero;
            registradores.$A3=valor;
        }
        
        //Registrador $T0       8
        if (enderecoReg == 8 ) {
            registradores.$T0=registradores.$zero;
            registradores.$T0=valor;
        }
        
        //Registrador $T1       9
        if (enderecoReg == 9 ) {
            registradores.$T1=registradores.$zero;
            registradores.$T1=valor;
        }
        
        //Registrador $T2       10
        if (enderecoReg == 10 ) {
            registradores.$T2=registradores.$zero;
            registradores.$T2=valor;
        }
        
        //Registrador $T3       11
        if (enderecoReg == 11 ) {
            registradores.$T3=registradores.$zero;
            registradores.$T3=valor;
        }
        
        //Registrador $T4       12
        if (enderecoReg == 12 ) {
            registradores.$T4=registradores.$zero;
            registradores.$T4=valor;
        }

        //Registrador $T5       13
        if (enderecoReg == 13 ) {       
        registradores.$T5=registradores.$zero;
        registradores.$T5=valor;
        }
        
        //Registrador $T6       14
        if (enderecoReg == 14 ) {
            registradores.$T6=registradores.$zero;
            registradores.$T6=valor;
        }
        
        //Registrador $T7       15
        if (enderecoReg == 15 ) {
            registradores.$T7=registradores.$zero;
            registradores.$T7=valor;
        }
        
        //Registrador $S0       16
        if (enderecoReg == 16 ) {
            registradores.$S0=registradores.$zero;
            registradores.$S0=valor;
        }
        
        //Registrador $S1       17
        if (enderecoReg == 17 ) {
            registradores.$S1=registradores.$zero;
            registradores.$S1=valor;
        }
        
        //Registrador $S2       18
        if (enderecoReg == 18 ) {
            registradores.$S2=registradores.$zero;
            registradores.$S2=valor;
        }
        
        //Registrador $S3       19
        if (enderecoReg == 19 ) {
            registradores.$S3=registradores.$zero;
            registradores.$S3=valor;
        }
        
        //Registrador $S4       20
        if (enderecoReg == 20 ) {
            registradores.$S4=registradores.$zero;
            registradores.$S4=valor;
        }
        
        //Registrador $S5       21
        if (enderecoReg == 21 ) {
            registradores.$S5=registradores.$zero;
            registradores.$S5=valor;
        }
        
        //Registrador $S6       22
        if (enderecoReg == 22 ) {
            registradores.$S6=registradores.$zero;
            registradores.$S6=valor;
        }
        
        //Registrador $S7       23
        if (enderecoReg == 23 ) {
            registradores.$S7=registradores.$zero;
            registradores.$S7=valor;
        }
        
        //Registrador $T8       24
        if (enderecoReg == 24 ) {
            registradores.$T8=registradores.$zero;
            registradores.$T8=valor;
        }
        
        //Registrador $T9       25
        if (enderecoReg == 25 ) {
            registradores.$T9=registradores.$zero;
            registradores.$T9=valor;
        }
        
        //Registrador $K0       26
        if (enderecoReg == 26 ) {
            registradores.$K0=registradores.$zero;
            registradores.$K0=valor;
        }
        
        //Registrador $K1       27
        if (enderecoReg == 27 ) {
            registradores.$K1=registradores.$zero;
            registradores.$K1=valor;
        }
        
        //Registrador $gp       28
        if (enderecoReg == 28 ) {
            registradores.$gp=registradores.$zero;
            registradores.$gp=valor;
        }
        
        //Registrador $sp       29
        if (enderecoReg == 29 ) {
            registradores.$sp=registradores.$zero;
            registradores.$sp=valor;
        }
        
        //Registrador $fp       30
        if (enderecoReg == 30 ) {
            registradores.$fp=registradores.$zero;
            registradores.$fp=valor;
        }
        
        //Registrador $ra       31
        if (enderecoReg == 31 ) {
            registradores.$ra=registradores.$zero;
            registradores.$ra=valor;
        }
    }
    
    public char [] getValorReg(int enderecoReg){
        //Registrador $zero     0
        if (enderecoReg == 0 ) {
            return registradores.$zero;
        }

        //Registrador $AT       1
        if (enderecoReg == 1 ) {
            return registradores.$AT;
        }

        //Registrador $V0       2
        if (enderecoReg == 2 ) {
            return registradores.$V0;
        } 

        //Registrador $V1       3
        if (enderecoReg == 3 ) {
            return registradores.$V1;
        }

        //Registrador $A0       4
        if (enderecoReg == 4 ) {
            return registradores.$A0;
        }

        //Registrador $A1       5
        if (enderecoReg == 5 ) {
            return registradores.$A1;
        }

        //Registrador $A2       6
        if (enderecoReg == 6 ) {
            return registradores.$A2;
        }

        //Registrador $A3       7
        if (enderecoReg == 7 ) {
            return registradores.$A3;
        }

        //Registrador $T0       8
        if (enderecoReg == 8 ) {
            return registradores.$T0;
        }

        //Registrador $T1       9
        if (enderecoReg == 9 ) {
            return registradores.$T1;
        }

        //Registrador $T2       10
        if (enderecoReg == 10 ) {
            return registradores.$T2;
        }

        //Registrador $T3       11
        if (enderecoReg == 11 ) {
            return registradores.$T3;
        }

        //Registrador $T4       12
        if (enderecoReg == 12 ) {
            return registradores.$T4;
        }

        //Registrador $T5       13
        if (enderecoReg == 13 ) {       
            return registradores.$T5;
        }

        //Registrador $T6       14
        if (enderecoReg == 14 ) {
            return registradores.$T6;
        }

        //Registrador $T7       15
        if (enderecoReg == 15 ) {
            return registradores.$T7;
        }

        //Registrador $S0       16
        if (enderecoReg == 16 ) {
            return registradores.$S0;
        }

        //Registrador $S1       17
        if (enderecoReg == 17 ) {
            return registradores.$S1;
        }

        //Registrador $S2       18
        if (enderecoReg == 18 ) {
            return registradores.$S2;
        }

        //Registrador $S3       19
        if (enderecoReg == 19 ) {
            return registradores.$S3;
        }

        //Registrador $S4       20
        if (enderecoReg == 20 ) {
            return registradores.$S4;
        }

        //Registrador $S5       21
        if (enderecoReg == 21 ) {
            return registradores.$S5;
        }

        //Registrador $S6       22
        if (enderecoReg == 22 ) {
            return registradores.$S6;
        }

        //Registrador $S7       23
        if (enderecoReg == 23 ) {
            return registradores.$S7;
        }

        //Registrador $T8       24
        if (enderecoReg == 24 ) {
            return registradores.$T8;
        }

        //Registrador $T9       25
        if (enderecoReg == 25 ) {
            return registradores.$T9;
        }

        //Registrador $K0       26
        if (enderecoReg == 26 ) {
            return registradores.$K0;
        }

        //Registrador $K1       27
        if (enderecoReg == 27 ) {
            return registradores.$K1;
        }

        //Registrador $gp       28
        if (enderecoReg == 28 ) {
            return registradores.$gp;
        }

        //Registrador $sp       29
        if (enderecoReg == 29 ) {
            return registradores.$sp;
        }

        //Registrador $fp       30
        if (enderecoReg == 30 ) {
            return registradores.$fp;
        }

        //Registrador $ra       31
        if (enderecoReg == 31 ) {
            return registradores.$ra;
        }


        return registradores.$zero;
    }

    public void imprimeValorReg(int enderecoReg){
        if (enderecoReg == 0 ) {
            //Registrador $zero     0
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$zero))));
        }

        //Registrador $AT       1
        if (enderecoReg == 1 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$AT))));
        }

        //Registrador $V0       2
        if (enderecoReg == 2 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$V0))));
        }

        //Registrador $V1       3
        if (enderecoReg == 3 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$V1))));
        }

        //Registrador $A0       4
        if (enderecoReg == 4 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$A0))));
        }

        //Registrador $A1       5
        if (enderecoReg == 5 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$A1))));
        }

        //Registrador $A2       6
        if (enderecoReg == 6 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$A2))));
        }

        //Registrador $A3       7
        if (enderecoReg == 7 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$A3))));
        }

        //Registrador $T0       8
        if (enderecoReg == 8 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T0))));
        }

        //Registrador $T1       9
        if (enderecoReg == 9 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T1))));
        }

        //Registrador $T2       10
        if (enderecoReg == 10 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T2))));
        }

        //Registrador $T3       11
        if (enderecoReg == 11 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T3))));
        }

        //Registrador $T4       12
        if (enderecoReg == 12 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T4))));
        }


        //Registrador $T5       13
        if (enderecoReg == 13 ) {     
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T5))));
        }

        //Registrador $T6       14
        if (enderecoReg == 14 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T6))));
        }

        //Registrador $T7       15
        if (enderecoReg == 15 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T7))));
        }

        //Registrador $S0       16
        if (enderecoReg == 16 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S0))));
        }

        //Registrador $S1       17
        if (enderecoReg == 17 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S1))));
        }

        //Registrador $S2       18
        if (enderecoReg == 18 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S2))));
        }

        //Registrador $S3       19
        if (enderecoReg == 19 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S3))));
        }

        //Registrador $S4       20
        if (enderecoReg == 20 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S4))));
        }

        //Registrador $S5       21
        if (enderecoReg == 21 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S5))));
        }

        //Registrador $S6       22
        if (enderecoReg == 22 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S6))));
        }

        //Registrador $S7       23
        if (enderecoReg == 23 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$S7))));
        }

        //Registrador $T8       24
        if (enderecoReg == 24 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T8))));
        }

        //Registrador $T9       25
        if (enderecoReg == 25 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$T9))));
        }

        //Registrador $K0       26
        if (enderecoReg == 26 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$K0))));
        }

        //Registrador $K1       27
        if (enderecoReg == 27 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$K1))));
        }

        //Registrador $gp       28
        if (enderecoReg == 28 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$gp))));
        }

        //Registrador $sp       29
        if (enderecoReg == 29 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$sp))));
        }

        //Registrador $fp       30
        if (enderecoReg == 30 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$fp))));
        }

        //Registrador $ra       31
        if (enderecoReg == 31 ) {
            System.out.println(String.format("0x%08x", Integer.parseInt(new String (registradores.$ra))));
        }

        
    }
}