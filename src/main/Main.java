package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Recebe parametros da main
        String filetText = new String (args [0]);   //Recebe nome do primeiro arquivo do parametro
        String fileData = new String (args [1]);    //Recebe nome do segundo arquivo do parametro

        //Inicia a decodificacao e o programa
        Inicio inicio = new Inicio();
        inicio.fillTextSection();
        inicio.fillDataSection();
        inicio.abreArquivo(filetText, fileData);

    }

    
}