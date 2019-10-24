package registradores;

public class OperacoesRegistradores{

    private Registradores registradores = new Registradores();

    public void setValorReg(int enderecoReg, char [] valor ){
        if (enderecoReg == 0 ) {
            //Registrador $zero     0
            System.out.println("Registrador $zero");
        }
        if (enderecoReg == 1 ) {
            //Registrador $AT       1
            System.out.println("Registrador $AT");
            registradores.$AT=valor;
        }
        if (enderecoReg == 2 ) {
            //Registrador $V0       2
            System.out.println("Registrador $V0");
            registradores.$V0=valor;
        } 
        if (enderecoReg == 3 ) {
            //Registrador $V1       3
            System.out.println("Registrador $V1");
            registradores.$V1=valor;
        }
        if (enderecoReg == 4 ) {
            //Registrador $A0       4
            System.out.println("Registrador $A0");
            registradores.$A0=valor;
        }
        if (enderecoReg == 5 ) {
            //Registrador $A1       5
            System.out.println("Registrador $A1");
            registradores.$A1=valor;
        }
        if (enderecoReg == 6 ) {
            //Registrador $A2       6
            System.out.println("Registrador $A2");
            registradores.$A2=valor;
        }
        if (enderecoReg == 7 ) {
            //Registrador $A3       7
            System.out.println("Registrador $A3");
            registradores.$A3=valor;
        }
        if (enderecoReg == 8 ) {
            //Registrador $T0       8
            System.out.println("Registrador $T0");
            registradores.$T0=valor;
        }
        if (enderecoReg == 9 ) {
            //Registrador $T1       9
            System.out.println("Registrador $T1");
            registradores.$T1=valor;
        }
        if (enderecoReg == 10 ) {
            //Registrador $T2       10
            System.out.println("Registrador $T2");
            registradores.$T2=valor;
        }
        if (enderecoReg == 11 ) {
            //Registrador $T3       11
            System.out.println("Registrador $T3");
            registradores.$T3=valor;
        }
        if (enderecoReg == 12 ) {
            //Registrador $T4       12
            System.out.println("Registrador $T4");
            registradores.$T4=valor;
        }
        if (enderecoReg == 13 ) {       
            //Registrador $T5       13
            System.out.println("Registrador $T5");
            registradores.$T5=valor;
        }
        if (enderecoReg == 14 ) {
            //Registrador $T6       14
            System.out.println("Registrador $T6");
            registradores.$T6=valor;
        }
        if (enderecoReg == 15 ) {
            //Registrador $T7       15
            System.out.println("Registrador $T7");
            registradores.$T7=valor;
        }
        if (enderecoReg == 16 ) {
            //Registrador $S0       16
            System.out.println("Registrador $S0");
            registradores.$S0=valor;
        }
        if (enderecoReg == 17 ) {
            //Registrador $S1       17
            System.out.println("Registrador $S1");
            registradores.$S1=valor;
        }
        if (enderecoReg == 18 ) {
            //Registrador $S2       18
            System.out.println("Registrador $S2");
            registradores.$S2=valor;
        }
        if (enderecoReg == 19 ) {
            //Registrador $S3       19
            System.out.println("Registrador $S3");
            registradores.$S3=valor;
        }
        if (enderecoReg == 20 ) {
            //Registrador $S4       20
            System.out.println("Registrador $S4");
            registradores.$S4=valor;
        }
        if (enderecoReg == 21 ) {
            //Registrador $S5       21
            System.out.println("Registrador $S5");
            registradores.$S5=valor;
        }
        if (enderecoReg == 22 ) {
            //Registrador $S6       22
            System.out.println("Registrador $S6");
            registradores.$S6=valor;
        }
        if (enderecoReg == 23 ) {
            //Registrador $S7       23
            System.out.println("Registrador $S7");
            registradores.$S7=valor;
        }
        if (enderecoReg == 24 ) {
            //Registrador $T8       24
            System.out.println("Registrador $T8");
            registradores.$T8=valor;
        }
        if (enderecoReg == 25 ) {
            //Registrador $T9       25
            System.out.println("Registrador $T9");
            registradores.$T9=valor;
        }
        if (enderecoReg == 26 ) {
            //Registrador $K0       26
            System.out.println("Registrador $K0");
            registradores.$K0=valor;
        }
        if (enderecoReg == 27 ) {
            //Registrador $K1       27
            System.out.println("Registrador $K1");
            registradores.$K1=valor;
        }
        if (enderecoReg == 28 ) {
            //Registrador $gp       28
            System.out.println("Registrador $gp");
            registradores.$gp=valor;
        }
        if (enderecoReg == 29 ) {
            //Registrador $sp       29
            System.out.println("Registrador $sp");
            registradores.$sp=valor;
        }
        if (enderecoReg == 30 ) {
            //Registrador $fp       30
            System.out.println("Registrador $fp");
            registradores.$fp=valor;
        }
        if (enderecoReg == 31 ) {
            //Registrador $ra       31
            System.out.println("Registrador $ra");
            registradores.$ra=valor;
        }
    }
    
    public char [] getValorReg(int enderecoReg){
        if (enderecoReg == 0 ) {
            //Registrador $zero     0
            return registradores.$zero;
        }
        if (enderecoReg == 1 ) {
            //Registrador $AT       1
            System.out.println("Registrador $AT");
            return registradores.$AT;
        }
        if (enderecoReg == 2 ) {
            //Registrador $V0       2
            System.out.println("Registrador $V0");
            return registradores.$V0;
        } 
        if (enderecoReg == 3 ) {
            //Registrador $V1       3
            System.out.println("Registrador $V1");
            return registradores.$V1;
        }
        if (enderecoReg == 4 ) {
            //Registrador $A0       4
            System.out.println("Registrador $A0");
            return registradores.$A0;
        }
        if (enderecoReg == 5 ) {
            //Registrador $A1       5
            System.out.println("Registrador $A1");
            return registradores.$A1;
        }
        if (enderecoReg == 6 ) {
            //Registrador $A2       6
            System.out.println("Registrador $A2");
            return registradores.$A2;
        }
        if (enderecoReg == 7 ) {
            //Registrador $A3       7
            System.out.println("Registrador $A3");
            return registradores.$A3;
        }
        if (enderecoReg == 8 ) {
            //Registrador $T0       8
            System.out.println("Registrador $T0");
            return registradores.$T0;
        }
        if (enderecoReg == 9 ) {
            //Registrador $T1       9
            System.out.println("Registrador $T1");
            return registradores.$T1;
        }
        if (enderecoReg == 10 ) {
            //Registrador $T2       10
            System.out.println("Registrador $T2");
            return registradores.$T2;
        }
        if (enderecoReg == 11 ) {
            //Registrador $T3       11
            System.out.println("Registrador $T3");
            return registradores.$T3;
        }
        if (enderecoReg == 12 ) {
            //Registrador $T4       12
            System.out.println("Registrador $T4");
            return registradores.$T4;
        }
        if (enderecoReg == 13 ) {       
            //Registrador $T5       13
            System.out.println("Registrador $T5");
            return registradores.$T5;
        }
        if (enderecoReg == 14 ) {
            //Registrador $T6       14
            System.out.println("Registrador $T6");
            return registradores.$T6;
        }
        if (enderecoReg == 15 ) {
            //Registrador $T7       15
            System.out.println("Registrador $T7");
            return registradores.$T7;
        }
        if (enderecoReg == 16 ) {
            //Registrador $S0       16
            System.out.println("Registrador $S0");
            return registradores.$S0;
        }
        if (enderecoReg == 17 ) {
            //Registrador $S1       17
            System.out.println("Registrador $S1");
            return registradores.$S1;
        }
        if (enderecoReg == 18 ) {
            //Registrador $S2       18
            System.out.println("Registrador $S2");
            return registradores.$S2;
        }
        if (enderecoReg == 19 ) {
            //Registrador $S3       19
            System.out.println("Registrador $S3");
            return registradores.$S3;
        }
        if (enderecoReg == 20 ) {
            //Registrador $S4       20
            System.out.println("Registrador $S4");
            return registradores.$S4;
        }
        if (enderecoReg == 21 ) {
            //Registrador $S5       21
            System.out.println("Registrador $S5");
            return registradores.$S5;
        }
        if (enderecoReg == 22 ) {
            //Registrador $S6       22
            System.out.println("Registrador $S6");
            return registradores.$S6;
        }
        if (enderecoReg == 23 ) {
            //Registrador $S7       23
            System.out.println("Registrador $S7");
            return registradores.$S7;
        }
        if (enderecoReg == 24 ) {
            //Registrador $T8       24
            System.out.println("Registrador $T8");
            return registradores.$T8;
        }
        if (enderecoReg == 25 ) {
            //Registrador $T9       25
            System.out.println("Registrador $T9");
            return registradores.$T9;
        }
        if (enderecoReg == 26 ) {
            //Registrador $K0       26
            System.out.println("Registrador $K0");
            return registradores.$K0;
        }
        if (enderecoReg == 27 ) {
            //Registrador $K1       27
            System.out.println("Registrador $K1");
            return registradores.$K1;
        }
        if (enderecoReg == 28 ) {
            //Registrador $gp       28
            System.out.println("Registrador $gp");
            return registradores.$gp;
        }
        if (enderecoReg == 29 ) {
            //Registrador $sp       29
            System.out.println("Registrador $sp");
            return registradores.$sp;
        }
        if (enderecoReg == 30 ) {
            //Registrador $fp       30
            System.out.println("Registrador $fp");
            return registradores.$fp;
        }
        if (enderecoReg == 31 ) {
            //Registrador $ra       31
            System.out.println("Registrador $ra");
            return registradores.$ra;
        }

        return registradores.$zero;
    }

    public void imprimeValorReg(int enderecoReg){
        if (enderecoReg == 0 ) {
            //Registrador $zero     0
            System.out.println(registradores.$zero);
        }
        if (enderecoReg == 1 ) {
            //Registrador $AT       1
            System.out.println(registradores.$AT);
        }
        if (enderecoReg == 2 ) {
            //Registrador $V0       2
            System.out.println(registradores.$V0);
        }
        if (enderecoReg == 3 ) {
            //Registrador $V1       3
            System.out.println(registradores.$V1);
        }
        if (enderecoReg == 4 ) {
            //Registrador $A0       4
            System.out.println(registradores.$A0);
        }
        if (enderecoReg == 5 ) {
            //Registrador $A1       5
            System.out.println(registradores.$A1);
        }
        if (enderecoReg == 6 ) {
            //Registrador $A2       6
            System.out.println(registradores.$A2);
        }
        if (enderecoReg == 7 ) {
            //Registrador $A3       7
            System.out.println(registradores.$A3);
        }
        if (enderecoReg == 8 ) {
            //Registrador $T0       8
            System.out.println(registradores.$T0);
        }
        if (enderecoReg == 9 ) {
            //Registrador $T1       9
            System.out.println(registradores.$T1);
        }
        if (enderecoReg == 10 ) {
            //Registrador $T2       10
            System.out.println(registradores.$T2);
        }
        if (enderecoReg == 11 ) {
            //Registrador $T3       11
            System.out.println(registradores.$T3);
        }
        if (enderecoReg == 12 ) {
            //Registrador $T4       12
            System.out.println(registradores.$T4);
        }
        if (enderecoReg == 13 ) {       
            //Registrador $T5       13
            System.out.println(registradores.$T5);
        }
        if (enderecoReg == 14 ) {
            //Registrador $T6       14
            System.out.println(registradores.$T6);
        }
        if (enderecoReg == 15 ) {
            //Registrador $T7       15
            System.out.println(registradores.$T7);
        }
        if (enderecoReg == 16 ) {
            //Registrador $S0       16
            System.out.println(registradores.$S0);
        }
        if (enderecoReg == 17 ) {
            //Registrador $S1       17
            System.out.println(registradores.$S1);
        }
        if (enderecoReg == 18 ) {
            //Registrador $S2       18
            System.out.println(registradores.$S2);
        }
        if (enderecoReg == 19 ) {
            //Registrador $S3       19
            System.out.println(registradores.$S3);
        }
        if (enderecoReg == 20 ) {
            //Registrador $S4       20
            System.out.println(registradores.$S4);
        }
        if (enderecoReg == 21 ) {
            //Registrador $S5       21
            System.out.println(registradores.$S5);
        }
        if (enderecoReg == 22 ) {
            //Registrador $S6       22
            System.out.println(registradores.$S6);
        }
        if (enderecoReg == 23 ) {
            //Registrador $S7       23
            System.out.println(registradores.$S7);
        }
        if (enderecoReg == 24 ) {
            //Registrador $T8       24
            System.out.println(registradores.$T8);
        }
        if (enderecoReg == 25 ) {
            //Registrador $T9       25
            System.out.println(registradores.$T9);
        }
        if (enderecoReg == 26 ) {
            //Registrador $K0       26
            System.out.println(registradores.$K0);
        }
        if (enderecoReg == 27 ) {
            //Registrador $K1       27
            System.out.println(registradores.$K1);
        }
        if (enderecoReg == 28 ) {
            //Registrador $gp       28
            System.out.println(registradores.$gp);
        }
        if (enderecoReg == 29 ) {
            //Registrador $sp       29
            System.out.println(registradores.$sp);
        }
        if (enderecoReg == 30 ) {
            //Registrador $fp       30
            System.out.println(registradores.$fp);
        }
        if (enderecoReg == 31 ) {
            //Registrador $ra       31
            System.out.println(registradores.$ra);
        }
    }
}