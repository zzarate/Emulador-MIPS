package main;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Scanner;

public class LeArquivo {
	
	//Abre o arquivo binario em MIPS
	void abrirArquivo () throws IOException  {
		System.out.println("Insira o caminho do arquivo a ser lido: ");
		Scanner scanner = new Scanner (System.in);
		String localArquivo = scanner.nextLine();

		FileInputStream arquivo = new FileInputStream(localArquivo);

		//Especificando codificação UTF-8 explicitamente
		InputStreamReader inputStreamReader = new InputStreamReader(arquivo, "UTF-8");

		try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader) ) {
			String linha;
			while ((linha = bufferedReader.readLine()) != null) {
				System.out.println (linha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
