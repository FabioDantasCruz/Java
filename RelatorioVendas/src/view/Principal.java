package view;

import java.io.File;
import java.io.IOException;

import controller.*;

public class Principal {

	public static void main (String [] Args) throws IOException {
		
		

		String pasta = "data\\in";

		File f = new File(pasta);
		
		
		GerarRelatorio gerarRelatorio = new GerarRelatorio();
		
		LerArquivo read = new LerArquivo();
		System.out.println("Lendo Arquivos");
		while(true) {
			File[] arquivos = f.listFiles(); // retorna um array de Files
			for(File i: arquivos) {
			gerarRelatorio.ProcessaRelatorio(i.getName(), read.CarregaArquivos(i));;

		
		}
		}

		
		
	}

}
