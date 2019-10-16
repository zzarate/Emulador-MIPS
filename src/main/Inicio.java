package main;

import instrucoes.SeparaDados;
import registradores.*;

public class Inicio {

    private Registradores registradores = new Registradores();
    private HILO hilo = new HILO();
    private ProgramCounter pc = new ProgramCounter();
    private byte [] memory = new byte [4096 * 4];
    Memoria memoria = new Memoria();

    /*Abrir arquivos recebidos como argumento*/
    void abreArquivo (String filetText, String fileData){
        //Abre e le o arquivo
        LeArquivo arquivo = new LeArquivo();
        arquivo.abrirArquivo(filetText);    //Le primeiro arquivo
        salvaArquivoMemText(arquivo);       //Salva na memoria de texto

        arquivo.abrirArquivo(fileData);
        salvaArquivoMemData(arquivo);
    }

    void salvaArquivoMemText (LeArquivo arquivo){
        SeparaDados separaDados = new SeparaDados();
        separaDados.separaInstrucao (arquivo.arquivo, memory, memoria);    //Envia arquivo para separar por instrução
    }

    void salvaArquivoMemData (LeArquivo arquivo){

    }

    /*Inicializa valores*/

    //Memoria
    void fillTextSection (){
        for (int i = memoria.minTextSection; i < memoria.maxTextSection; i++) {
            memory[i]= 0;
        }
    }

    void fillDataSection (){
        for (int i = memoria.minDataSection; i < memoria.maxDataSection; i++) {
            memory[i]= 0;
        }
    }

}