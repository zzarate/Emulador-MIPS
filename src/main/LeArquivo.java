package main;

import java.io.File;

public class LeArquivo {
	File arquivo;

	//Abre o arquivo binario em MIPS
	void abrirArquivo (String nomeArquivo){
		try {
			String localArquivo = System.getProperty("user.dir") + "\\" + nomeArquivo;
			arquivo = new File(localArquivo);
		} catch (Exception e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
	}
}