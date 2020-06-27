package com.niit.shoppingdemoservlet.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String name;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if(id == 0)		
			this.id = UUID.randomUUID().toString().substring(1, 4).hashCode();
		
		else	
			this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
}
