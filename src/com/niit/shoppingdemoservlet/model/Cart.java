package com.niit.shoppingdemoservlet.model;

import java.io.Serializable;

public class Cart implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
}