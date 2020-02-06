package controller;

import java.io.File;
import java.util.ArrayList;

import model.Cliente;
import model.ItemVenda;
import model.Relatorio;
import model.Vendas;
import model.Vendedor;

public class GerarRelatorio {

	String pastaArquivoEntrada = "data\\in\\";
	String pastaArquivoSaida = "data\\out\\";

	LerArquivo leitura = new LerArquivo();
	GravarArquivo gravacao = new GravarArquivo();

	public void MoveArquivoProcessado(String nomeArquivo) {
		File arquivo = new File(pastaArquivoEntrada + nomeArquivo);

		File diretorioDestino = new File("data//processado");
		if (!diretorioDestino.exists()) {
			new File("data//processado").mkdir();
		} else {

			boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
			if (sucesso) {
				System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
			} else {
				System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
						+ diretorioDestino.getAbsolutePath() + "'");
			}
		}

	}

	public int RetornarQuantidadeClientes(Relatorio relatorio) {
		return relatorio.clientes.size();
	}

	public int RetornarQuantidadeVendedores(Relatorio relatorio) {

		return relatorio.vendedores.size();

	}

	public int RetornarIDMaiorVenda(Relatorio relatorio) {
		double valorMaiorVenda = 0;
		int idMaiorVenda = 0;
		ArrayList<Vendas> vendasProcessar = relatorio.vendas;

		for (Vendas venda : vendasProcessar) {
			double valorCalculo = 0; // preco total das vendas
			for (ItemVenda item : venda.listaItemVenda) {
				double valorVendaItem = item.getItemQuantity() * item.getItemPrice();
				valorCalculo += valorVendaItem;

			}
			if (valorCalculo > valorMaiorVenda) {
				valorMaiorVenda = valorCalculo;
				idMaiorVenda = venda.getVendaID();
			}
		}

		return idMaiorVenda;
	}

	public String RetornarPiorVendedor(Relatorio relatorio) {
		String vendedorPior = "";
		double valorVenda = 100000; // um valor muito alto
		ArrayList<Vendas> vendasProcessar = relatorio.vendas;

		for (Vendas venda : vendasProcessar) {

			double valorCalculo = 0; // preco total das vendas
			for (ItemVenda item : venda.listaItemVenda) {
				double valorVendaItem = item.getItemQuantity() * item.getItemPrice();
				valorCalculo += valorVendaItem;

			}
			if (valorCalculo < valorVenda) {
				valorVenda = valorCalculo;
				vendedorPior = venda.getVendedor();
			}
		}

		return vendedorPior;
	}

	public void ProcessaRelatorio(String nomeArquivo, ArrayList<String> linhas) {

		Relatorio relatorio = new Relatorio();
		relatorio.vendas = new ArrayList<Vendas>();
		relatorio.vendedores = new ArrayList<Vendedor>();
		relatorio.clientes = new ArrayList<Cliente>();
		Vendas venda;
		Cliente cliente;
		Vendedor vendedor;

		for (int i = 0; i < linhas.size(); i++) {

			String[] linhaTratar = linhas.get(i).split("ç");

			if (linhaTratar[0].contains("001")) {
				vendedor = new Vendedor();
				vendedor.setCpf(linhaTratar[1]);
				vendedor.setName(linhaTratar[2]);
				vendedor.setSalary(Double.parseDouble(linhaTratar[3]));
				relatorio.vendedores.add(vendedor);
			} else if (linhaTratar[0].contains("002")) {

				cliente = new Cliente();
				cliente.setCnpj(linhaTratar[1]);
				cliente.setName(linhaTratar[2]);
				cliente.setBusinessArea(linhaTratar[3]);
				relatorio.clientes.add(cliente);

			} else if (linhaTratar[0].contains("003")) {
				venda = new Vendas();
				venda.setVendaID(Integer.parseInt(linhaTratar[1]));
				venda.setVendedor(linhaTratar[3]);
				venda.listaItemVenda = new ArrayList<ItemVenda>();
				String linhaItemVenda = linhaTratar[2].replace("[", "").replace("]", "");
				String[] linhaItensVendaTratar = linhaItemVenda.split(",");
				for (int j = 0; j < linhaItensVendaTratar.length; j++) {
					String[] linhaTratada = linhaItensVendaTratar[j].split("-");
					ItemVenda itemVenda = new ItemVenda();
					itemVenda.setItemID(Integer.parseInt(linhaTratada[0]));
					itemVenda.setItemQuantity(Integer.parseInt(linhaTratada[1]));
					itemVenda.setItemPrice(Double.parseDouble(linhaTratada[2]));
					venda.listaItemVenda.add(itemVenda);
				}
				relatorio.vendas.add(venda);

			}
		}

		relatorio.setIdVendaMaior(RetornarIDMaiorVenda(relatorio));
		relatorio.setPiorVendedor(RetornarPiorVendedor(relatorio));
		relatorio.setQuantidadeCliente(RetornarQuantidadeClientes(relatorio));
		relatorio.setQuantidadeVendedores(RetornarQuantidadeVendedores(relatorio));

		String caminhoNomeArquivo = pastaArquivoSaida + "out" + nomeArquivo;

		gravacao.SalvarDados(caminhoNomeArquivo, relatorio);
		MoveArquivoProcessado(nomeArquivo);
	}

}
