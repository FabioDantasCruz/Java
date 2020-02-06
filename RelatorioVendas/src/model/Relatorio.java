package model;

import java.util.ArrayList;

public class Relatorio {
	
	public ArrayList<Cliente> clientes;
	public ArrayList<Vendedor> vendedores;
	public ArrayList<Vendas> vendas;

	private int quantidadeCliente;
	private int quantidadeVendedores;
	private int idVendaMaior;
	private String piorVendedor;
	
	
	
	public int getQuantidadeCliente() {
		return quantidadeCliente;
	}
	public void setQuantidadeCliente(int quantidadeCliente) {
		this.quantidadeCliente = quantidadeCliente;
	}
	public int getQuantidadeVendedores() {
		return quantidadeVendedores;
	}
	public void setQuantidadeVendedores(int quantidadeVendedores) {
		this.quantidadeVendedores = quantidadeVendedores;
	}
	public int getIdVendaMaior() {
		return idVendaMaior;
	}
	public void setIdVendaMaior(int idVendaMaior) {
		this.idVendaMaior = idVendaMaior;
	}
	public String getPiorVendedor() {
		return piorVendedor;
	}
	public void setPiorVendedor(String piorVendedor) {
		this.piorVendedor = piorVendedor;
	}
	

	
	
}
