package com.classes.servlets;

public class CartLine {
	private int id;
	private int cartId;
	private int productId;
    private int quantity;
    
    public CartLine(int id, int cart_id, int product_id, int quantity) {
        this.id = id;
        this.cartId = cart_id;
        this.productId = product_id;
        this.quantity = quantity;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cart_id) {
		this.cartId = cart_id;
	}

    public int getProductId() {
		return productId;
	}

	public void setProductId(int product_id) {
		this.productId = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}