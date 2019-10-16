package instrucoes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import main.Memoria;

public class SeparaDados{

    //Pega o conteudo presente no arquivo, e separa em string de 32 bits, big endian
	public void separaInstrucao (File arquivo, byte [] memory ,Memoria memoria){
		try {
			byte[] conteudo = Files.readAllBytes(arquivo.toPath());
			for (int i = 0; i < conteudo.length; i+=4) {

				/*Envia instrução para a memoria de texto*/
				for (int j = 3; j >= 0; j--) {
					memoria.salvaMemText(memory, conteudo[i]);
				}

				/* Salva as instruções em uma string
				String instrucao;
				instrucao = null;
				instrucao= Integer.toBinaryString((conteudo[i+3] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+2] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+1] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i] & 0xFF) + 0x100).substring(1);
				*/
			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		
	}

	/*Separa os dados em 4 bytes para enviar para a memoria de dados*/
	public void separaDado (File arquivo, byte [] memory ,Memoria memoria){
		try {
			byte[] conteudo = Files.readAllBytes(arquivo.toPath());
			for (int i = 0; i < conteudo.length; i+=4) {

				/*Envia os dados do arquivo para a memoria de dados*/
				for (int j = 3; j >= 0; j--) {
					memoria.salvaMemData (memory, conteudo[i]);
				}
			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		
	}
}