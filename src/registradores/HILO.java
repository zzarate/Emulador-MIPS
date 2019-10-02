package registradores;

public class HILO {
	//HILO
    private int[] HILO = new int [64];

    //Define valor no HILO
    void setHilo (int [] value_64){
        for (int i =0; i<64; i++){
            HILO[i] = value_64 [i];
        }
    }

    //Devolve valor armazenaddo no LO
    int [] getLO (){
        int [] dest_LO;
        dest_LO = new int [32];

        for (int i = 0; i<32; i++) {
            dest_LO[i]= HILO [i];
        }
        return dest_LO;
    }

    //Devolve valor armazenaddo no HI
    int [] getHI (){
        int [] dest_HI;
        dest_HI = new int [32];
        for (int i = 32; i<64; i++) {
            dest_HI[i]= HILO [i];
        }
        return dest_HI;
    }  
}
