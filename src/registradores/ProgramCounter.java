package registradores;

public class ProgramCounter {

	//Program counter
    private char[] $PC = new char [32];
    
    void iniciaPC (){
        for (char i=0; i<32; i++){
            $PC[i]= 0;
        }
    }
    
    void proximoPC (char [] proximaInstrucao){
        $PC = proximaInstrucao;
    }
}
