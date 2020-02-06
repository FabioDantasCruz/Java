package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerArquivo {

	public ArrayList<String> CarregaArquivos(File F) throws IOException {
		ArrayList<String> linhasArquivo = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new FileReader(F));

		while (br.ready()) {
			linhasArquivo.add(br.readLine());

		}

		br.close();

		return linhasArquivo;

	}

}
