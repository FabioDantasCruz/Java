package model;

public class ItemVenda {

	private int itemID;
	private int itemQuantity;
	private double itemPrice;

	public ItemVenda() {
		this(0,0,0);
	}
	public ItemVenda(int itemID, int itemQuantity, double itemPrice) {
		this.itemID = itemID;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
