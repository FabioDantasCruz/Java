package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import model.Relatorio;

public class GravarArquivo {

	public void SalvarDados(String caminhoArquivo, Relatorio relatorio) {

		try {
			
			FileWriter arquivo = new FileWriter(caminhoArquivo, true);
			BufferedWriter s = new BufferedWriter(arquivo);
			s.write("Relatório gerado em: " + LocalDateTime.now().toString());
			s.newLine();
			s.write("Quantidade de clientes: " + Integer.toString(relatorio.getQuantidadeCliente()));
			s.newLine();
			s.write("Quantidade de vendedores: " + Integer.toString(relatorio.getQuantidadeVendedores()));
			s.newLine();
			s.write("ID da venda mais cara: " + Integer.toString(relatorio.getIdVendaMaior()));
			s.newLine();
			s.write("Nome do pior vendedor: " + relatorio.getPiorVendedor());
			s.newLine();
			System.out.println("Relatório: " + caminhoArquivo + " salvo");
			s.flush();
			s.close();
		

		} catch (Exception ex) {
			System.out.println("Erro" + ex.getMessage());
		}
	}

}
