package main;

import instrucoes.Decodifica;
import registradores.OperacoesRegistradores;

public class Inicio {

    //Objetos necessarios para executar o programa
    private LeArquivo arquivo = new LeArquivo();
    private Memoria memoria = new Memoria();
    private SeparaDados separaDados = new SeparaDados();
    private Decodifica decodifica = new Decodifica();
    private OperacoesRegistradores opReg = new OperacoesRegistradores();
    

    /*Abrir arquivos recebidos como argumento*/
    void abreArquivo (String filetText, String fileData){
        //Abre e le o arquivo
        arquivo.abrirArquivo(filetText);    //Le primeiro arquivo
        separaDados.salvaInstrucao (arquivo.arquivo, memoria);       //Salva na memoria de texto

        arquivo.abrirArquivo(fileData);     //Le arquivo de dados
        separaDados.salvaDados (arquivo.arquivo, memoria);       //Armazena arquivo lido na memoria
    }

    /*Executa instrucoes localizadas na memoria*/
    void executaInstrucoes (){

        /*  Executa uma instrução da memoria */
        for (opReg.getPC() ; opReg.getPC() < 0x0fff; opReg.setPC(opReg.getPC()+4)) { //verificar se esta contando de 4 em 4

            /*  Salva as instruções de 4 bytes (32 bits) em uma string
             *  a partir do endereço do PC */ 
            String instrucao = null;
            instrucao = separaDados.separaInstrucao(instrucao, opReg.getPC(), memoria.memory); // <<---- problema
            decodifica.separaInstrucao(instrucao, opReg.getPC(), opReg, memoria); //Decodifica e executa a instrucao << erro
        }
    }


    /*Inicializa valores*/

    //Memoria - Inicia toda a memoria com zeros
    void fillMem (){
        for (int i = memoria.minTextSection; i < memoria.maxStack; i++) {
            memoria.memory[i]= 0;
        }
    }

    void fillRegistradores (){
        for (int i = 0; i < 28; i++) {
            opReg.setValorReg(i, opReg.getValorReg(0), memoria);
        }
        opReg.setValorReg(30, opReg.getValorReg(0), memoria);
        opReg.setValorReg(31, opReg.getValorReg(0), memoria);


        int temp = 0x1800;
        String aux = Integer.toBinaryString(temp);
        opReg.setValorReg(28, aux.toCharArray(), memoria);    //Atribui o endereço 0x1800 para o $sp
        temp = 0x00003ffc;
        aux = Integer.toBinaryString(temp);
        opReg.setValorReg(29, aux.toCharArray(), memoria);    //Atribui o endereço  0x00003ffc para o $fp
    }
}