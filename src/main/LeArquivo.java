package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class LeArquivo {
	
	//Abre o arquivo binario em MIPS
	void abrirArquivo () throws IOException  {
		System.out.println("Insira o caminho do arquivo a ser lido: ");
		Scanner scanner = new Scanner (System.in);
		String localArquivo = scanner.nextLine();
		
		File arquivo = new File (localArquivo);
		byte[] fileBytes = Files.readAllBytes(arquivo.toPath());
		char singleChar;
		for (byte b : fileBytes) {
			singleChar = (char) b;
			System.out.println(singleChar);
		}
		scanner.close();
	}
}
