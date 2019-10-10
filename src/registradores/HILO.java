package registradores;

public class HILO {
	//HILO
    private char[] HILO = new char [64];

    //Define valor no HILO
    public void setHilo (char [] value_64){
        for (int i =0; i<64; i++){
            HILO[i] = value_64 [i];
        }
    }

    //Devolve valor armazenaddo no LO
    public char [] getLO (){
        char [] dest_LO;
        dest_LO = new char [32];

        for (int i = 0; i<32; i++) {
            dest_LO[i]= HILO [i];
        }
        return dest_LO;
    }

    //Devolve valor armazenaddo no HI
    char [] getHI (){
        char [] dest_HI;
        dest_HI = new char [32];
        for (int i = 32; i<64; i++) {
            dest_HI[i]= HILO [i];
        }
        return dest_HI;
    }  
}
