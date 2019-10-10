package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import registradores.ProgramCounter;;

public class InicioPrograma{

    //Pega o conteudo presente no arquivo, e separa em string de 32 bits, big endian
	void separaInstrucao (File arquivo){
		Decodifica decode = new Decodifica();
		ProgramCounter PC = new ProgramCounter();
		try {
			byte[] conteudo = Files.readAllBytes(arquivo.toPath());
			for (int i = 0; i < conteudo.length; i+=4) {
				String instrucao;
				instrucao = null;

				instrucao= Integer.toBinaryString((conteudo[i+3] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+2] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+1] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i] & 0xFF) + 0x100).substring(1);

				//Chamar metodo para decodificar instrução
				decode.separaInstrucao(instrucao);
			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		
	}
}