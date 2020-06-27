package com.niit.shoppingdemoservlet.model;

import java.io.Serializable;
import java.sql.Date;

public class Sales implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Date date;
	private int amount;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}