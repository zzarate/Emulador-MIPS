package registradores;

/*******************************
 * Define os registradores *
 *******************************/

public class Registradores {
	//Registrador Zero
    final char $zero = 0;

    //Para valores de resultados e operacoes
    char[] $V0 = new char [32];
    char[] $V1 = new char [32];

    //Argumentos
    char[] $A0 = new char [32];
    char[] $A1 = new char [32];
    char[] $A2 = new char [32];
    char[] $A3 = new char [32];

    //Temporarios
    char[] $T0 = new char [32];
    char[] $T1 = new char [32];
    char[] $T2 = new char [32];
    char[] $T3 = new char [32];
    char[] $T4 = new char [32];
    char[] $T5 = new char [32];
    char[] $T6 = new char [32];
    char[] $T7 = new char [32];
        
    //Salvos
    char[] $S0 = new char [32];
    char[] $S1 = new char [32];
    char[] $S2 = new char [32];
    char[] $S3 = new char [32];
    char[] $S4 = new char [32];
    char[] $S5 = new char [32];
    char[] $S6 = new char [32];
    char[] $S7 = new char [32];

    //Temporarios
    char[] $T8 = new char [32];
    char[] $T9 = new char [32];

    //Ponteiro Global
    char[] $gp = new char [32];

    //Ponteiro Stack (pilha)
    char[] $sp = new char [32];

    //Ponteiro Frame
    char[] $fp = new char [32];

    //Endereco de retorno
    char[] $ra = new char [32];
}
