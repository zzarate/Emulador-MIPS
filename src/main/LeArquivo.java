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

		imprimeDados(arquivo);

		scanner.close();
	}

	//Pega o conteudo presente no arquivo, e separa em string de 32 bits, big endian
	void separaInstrucao (File arquivo){
		Decodifica decode = new Decodifica();
		try {
			byte[] conteudo = Files.readAllBytes(arquivo.toPath());
			for (int i = 0; i < conteudo.length; i+=4) {
				String instrucao;
				instrucao = null;

				instrucao =Integer.toBinaryString((conteudo[i+3] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+2] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+1] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i] & 0xFF) + 0x100).substring(1);

				//Chamar metodo para decodificar instrução
				decode.decodificaInstrucao(instrucao);
			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
		
	}

	//Metodo para testar se le os dados corretamente
	void imprimeDados (File arquivo){
		try {
			byte [] conteudo = Files.readAllBytes(arquivo.toPath());

			//Imprime de acordo com a tabela ASCII
			System.out.println ("Conteudo: ");
			System.out.println(new String(conteudo));
			//***************************************/
			
			//For para exiber conteudo do arquivo em string de bits
			int j = 0;
			for (int i = 0; i < conteudo.length; i++) {
				//Instrução impressa em bytes
				System.out.println ("Instrucao numero " + j + ": ");
				System.out.println(Integer.toBinaryString((conteudo[i]) + 0x100).substring(1));
				System.out.println(Integer.toBinaryString((conteudo[i+1]) + 0x100).substring(1));
				System.out.println(Integer.toBinaryString((conteudo[i+2]) + 0x100).substring(1));
				System.out.println(Integer.toBinaryString((conteudo[i+3]) + 0x100).substring(1));
				String instrucao= null;

				//Instrução com 4 bytes agrupados, imprimindo assim 32 bits, em little endian
				System.out.println("Instrucao em apenas uma linha (32 bits), instrucao nmr "+ j + ": ");
				instrucao =Integer.toBinaryString((conteudo[i] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+1] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+2] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+3] & 0xFF) + 0x100).substring(1);
				System.out.println(instrucao);
				System.out.println("");

				//Instrução de 4 bytes agrupados, imprimindo 32 bits em big endian
				// que é o formato utilizado pelo MIPS
				System.out.println("Intrução 32 bits Big Endian (inst nmr " + j + " ): ");
				instrucao =Integer.toBinaryString((conteudo[i+3] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+2] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i+1] & 0xFF) + 0x100).substring(1);
				instrucao= instrucao+ Integer.toBinaryString((conteudo[i] & 0xFF) + 0x100).substring(1);
				System.out.println(instrucao);

				j++;
				i+=4;
				System.out.println("---------------------------------------------------------");
				System.out.println("");
			}

		} catch (Exception e) {
			System.out.println("Erro ao ler o arquivo! Tente outro arquivo. ");
			System.out.println("Detalhes do erro: ");
			System.out.println("");
			e.printStackTrace();
		}
	}
}