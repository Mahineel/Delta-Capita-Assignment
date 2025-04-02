package com.deltacapita.models;

public class Cart {

	/*
	 * Generated Getters and Setters for simplicity. I Could use Lombok here.
	 */
	private String productName;
	private int quantity;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
