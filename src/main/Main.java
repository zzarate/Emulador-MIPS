package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        //Abre e le o arquivo
        LeArquivo arquivo = new LeArquivo();
        arquivo.abrirArquivo();

        //Inicia a decodificacao e o programa
        InicioPrograma inicio = new InicioPrograma();
        inicio.separaInstrucao(arquivo.arquivo);

        
        //Exibe uma mensagem avisando que o programa terminou de ser executado (????)
        System.out.println(" ___________________________");
        System.out.println("|                           |");
        System.out.println("|    Execução finalizada    |");
        System.out.println("|                           |");
        System.out.println("|___________________________|");
    }
}