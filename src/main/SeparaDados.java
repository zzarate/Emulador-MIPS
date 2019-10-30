package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import main.Memoria;

class SeparaDados{

    /* Le o conteudo presente no arquivo e armazena na memoria em formato big endian*/
	void salvaInstrucao (File arquivo, Memoria memoria){
		try {
			byte[] conteudo = Files.readAllBytes(arquivo.toPath());
			for (int i = 0; i < conteudo.length; i+=4) {

				/*Envia instrução para a memoria de texto*/
				for (int j = 3; j >= 0; j--) {
					memoria.salvaMemText(conteudo[i]);
				}
			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		
	}

	/*Separa os dados em 4 bytes para enviar para a memoria de dados*/
	void salvaDados (File arquivo, Memoria memoria){
		try {
			byte[] conteudo = Files.readAllBytes(arquivo.toPath());
			for (int i = 0; i < conteudo.length; i+=4) {

				/*Envia os dados do arquivo para a memoria de dados*/
				for (int j = 3; j >= 0; j--) {
					memoria.salvaMemData (conteudo[i]);
				}
			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		
	}

	/*Separa as instruções de 4 bytes, e devolve elas em uma string*/
	String separaInstrucao (String instrucao, int PC, byte [] memory){
		instrucao =Integer.toBinaryString((memory[PC+3] & 0xFF) + 0x100).substring(1);
		instrucao= instrucao+ Integer.toBinaryString((memory[PC+2] & 0xFF) + 0x100).substring(1);
		instrucao= instrucao+ Integer.toBinaryString((memory[PC+1] & 0xFF) + 0x100).substring(1);
		instrucao= instrucao+ Integer.toBinaryString((memory[PC] & 0xFF) + 0x100).substring(1);

		return instrucao;
	}
}