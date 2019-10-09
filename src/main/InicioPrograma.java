package main;

import java.io.IOException;

public class InicioPrograma {
    public static void main(String[] args) throws IOException {
        
        LeArquivo arquivo = new LeArquivo();
        arquivo.abrirArquivo();
        
        //Exibe uma mensagem avisando que o programa terminou de ser executado (????)
        System.out.println(" ___________________________");
        System.out.println("|                           |");
        System.out.println("|    Execução finalizada    |");
        System.out.println("|                           |");
        System.out.println("|___________________________|");
    }
}