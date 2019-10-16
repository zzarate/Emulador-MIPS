package registradores;

/*******************************
 * Define os registradores *
 *******************************/

public class Registradores {
	//Registrador Zero
    public final char $zero = 0;   //0

    //Assembler temporary
    public char[] $AT = new char [32]; //1

    //Para valores de resultados e operacoes
    public char[] $V0 = new char [32]; //2
    public char[] $V1 = new char [32]; //3

    //Argumentos
    public char[] $A0 = new char [32]; //4
    public char[] $A1 = new char [32]; //5
    public char[] $A2 = new char [32]; //6
    public char[] $A3 = new char [32]; //7

    //Temporarios
    public char[] $T0 = new char [32]; //8
    public char[] $T1 = new char [32]; //9
    public char[] $T2 = new char [32]; //10
    public char[] $T3 = new char [32]; //11
    public char[] $T4 = new char [32]; //12
    public char[] $T5 = new char [32]; //13
    public char[] $T6 = new char [32]; //14
    public char[] $T7 = new char [32]; //15
        
    //Salvos
    public char[] $S0 = new char [32]; //16
    public char[] $S1 = new char [32]; //17
    public char[] $S2 = new char [32]; //18
    public char[] $S3 = new char [32]; //19
    public char[] $S4 = new char [32]; //20
    public char[] $S5 = new char [32]; //21
    public char[] $S6 = new char [32]; //22
    public char[] $S7 = new char [32]; //23

    //Temporarios
    public char[] $T8 = new char [32]; //24
    public char[] $T9 = new char [32]; //25

    //Kernel SO
    public char[] $K0 = new char [32]; //26
    public char[] $K1 = new char [32]; //27

    //Ponteiro Global
    public char[] $gp = new char [32]; //28

    //Ponteiro Stack (pilha)
    public char[] $sp = new char [32]; //29

    //Ponteiro Frame
    public char[] $fp = new char [32]; //30

    //Endereco de retorno
    public char[] $ra = new char [32]; //31
}
