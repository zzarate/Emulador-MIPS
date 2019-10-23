package main;

import instrucoes.Decodifica;
//import registradores.*;

public class Inicio {

    private int PC;     //Program Counter

    //private Registradores registradores = new Registradores();
    //private HILO hilo = new HILO();
    private byte [] memory = new byte [4096 * 4];

    //Objetos necessarios para executar o programa
    private LeArquivo arquivo = new LeArquivo();
    private Memoria memoria = new Memoria();
    private SeparaDados separaDados = new SeparaDados();
    private Decodifica decodifica = new Decodifica();
    

    /*Abrir arquivos recebidos como argumento*/
    void abreArquivo (String filetText, String fileData){
        //Abre e le o arquivo
        arquivo.abrirArquivo(filetText);    //Le primeiro arquivo
        separaDados.salvaInstrucao (arquivo.arquivo, memory, memoria);       //Salva na memoria de texto

        arquivo.abrirArquivo(fileData);     //Le arquivo de dados
        separaDados.salvaDados (arquivo.arquivo, memory, memoria);       //Armazena arquivo lido na memoria
    }

    /*Executa instrucoes localizadas na memoria*/
    void executaInstrucoes (){

        /*  Executa uma instrução da memoria */
        for (PC = 0x0 ; PC < 0x0fff; PC+= 4) {

            /*  Salva as instruções de 4 bytes (32 bits) em uma string
             *  a partir do endereço do PC */ 
            String instrucao = null;
            instrucao = separaDados.separaInstrucao(instrucao, PC, memory);
            decodifica.separaInstrucao(instrucao);

            //Verificar se pc precisa ser alterado
            

            //Teste para saber se esta lendo as instruções corretamente
            System.out.println(instrucao);
            System.out.println("");

        }
    }


    /*Inicializa valores*/

    //Memoria - Inicia toda a memoria com zeros
    void fillMem (){
        for (int i = memoria.minTextSection; i < memoria.maxStack; i++) {
            memory[i]= 0;
        }
    }

    void fillRegistradores (){

    }

    void alteraValorPC (){

    }

}