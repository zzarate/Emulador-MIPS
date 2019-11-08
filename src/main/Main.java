package main;

public class Main {
    public static void main(String[] args){
    	
        //Recebe parametros da main
        String filetText = args [0];   //Recebe nome do primeiro arquivo do parametro
        String fileData = args [1];    //Recebe nome do segundo arquivo do parametro

        //Inicia a decodificacao e o programa
        Inicio inicio = new Inicio();
        inicio.fillMem();
        inicio.fillRegistradores();
        inicio.abreArquivo(filetText, fileData);
        inicio.executaInstrucoes();
        System.exit(1);

    }
}