package main;

import java.io.File;
import java.nio.file.Files;

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
		//Descomentar para verificar se esta lendo corretamenta
		//Somente para debug
		//imprimeDados(arquivo);
	}

	//Metodo para testar se le os dados corretamente ***DEBUG****
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