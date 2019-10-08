package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class LeArquivo {
	
	//Abre o arquivo binario em MIPS
	void abrirArquivo () throws IOException  {

		//Le o arquivo .bin
		System.out.println("Insira o caminho do arquivo (.bin) a ser lido: ");
		Scanner scanner = new Scanner (System.in);
		String localArquivo = scanner.nextLine();

		File arquivo = new File(localArquivo);

		try {
			byte [] conteudo = Files.readAllBytes(arquivo.toPath());
			System.out.println(new String(conteudo));
		} catch (Exception e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		scanner.close();
	}
}
