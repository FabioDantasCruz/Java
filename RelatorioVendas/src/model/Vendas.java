package model;

import java.util.ArrayList;

public class Vendas {
	private int vendaID;
	public ArrayList<ItemVenda> listaItemVenda;
	private String vendedor;

	public Vendas() {
		this.vendaID = vendaID;
		this.listaItemVenda = listaItemVenda;
		this.vendedor = vendedor;
	}

	public int getVendaID() {
		return vendaID;
	}

	public void setVendaID(int vendaID) {
		this.vendaID = vendaID;
	}


	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

}
