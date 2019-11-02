package registradores;

/*******************************
 * Define os registradores *
 *******************************/

public class Registradores {

    int PC = 0x0;     //Program Counter

	//Registrador Zero
    final char [] $zero = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0','0', '0', '0', '0', '0', '0', '0'};   //0

    //Assembler temporary
    char[] $AT = new char [32]; //1

    //Para valores de resultados e operacoes
    char[] $V0 = new char [32]; //2
    char[] $V1 = new char [32]; //3

    //Argumentos
    char[] $A0 = new char [32]; //4
    char[] $A1 = new char [32]; //5
    char[] $A2 = new char [32]; //6
    char[] $A3 = new char [32]; //7

    //Temporarios
    char[] $T0 = new char [32]; //8
    protected char[] $T1 = new char [32]; //9
    char[] $T2 = new char [32]; //10
    char[] $T3 = new char [32]; //11
    char[] $T4 = new char [32]; //12
    char[] $T5 = new char [32]; //13
    char[] $T6 = new char [32]; //14
    char[] $T7 = new char [32]; //15
        
    //Salvos
    char[] $S0 = new char [32]; //16
    char[] $S1 = new char [32]; //17
    char[] $S2 = new char [32]; //18
    char[] $S3 = new char [32]; //19
    char[] $S4 = new char [32]; //20
    char[] $S5 = new char [32]; //21
    char[] $S6 = new char [32]; //22
    char[] $S7 = new char [32]; //23

    //Temporarios
    char[] $T8 = new char [32]; //24
    char[] $T9 = new char [32]; //25

    //Kernel SO
    char[] $K0 = new char [32]; //26
    char[] $K1 = new char [32]; //27

    //Ponteiro Global
    char[] $gp = new char [32]; //28

    //Ponteiro Stack (pilha)
    char[] $sp = new char [32]; //29

    //Ponteiro Frame
    char[] $fp = new char [32]; //30

    //Endereco de retorno
    char[] $ra = new char [32]; //31
}
