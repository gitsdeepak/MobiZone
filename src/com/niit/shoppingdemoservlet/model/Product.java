package com.niit.shoppingdemoservlet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product implements Serializable {
	
	public Product() {}
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int productId;
	/*@Column(unique=true)*/
	private String productName;
	private String productDescription;
	private int categoryId;
	private String productImage;
	private String productBrand;
	private int productPrice;
	private int productDiscount;
	private int productQuantity;
	
	/**
	 * @return the productId
	 */

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getproductName() {
		return productName;
	}

	/**
	 * @param productName the pName to set
	 */
	public void setproductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getproductDescription() {
		return productDescription;
	}

	/**
	 * @param pDesc the productDescription to set
	 */
	public void setproductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the productImage
	 */
	public String getproductImage() {
		return productImage;
	}

	/**
	 * @param pImage the productImage to set
	 */
	public void setproductImage(String productImage) {
		this.productImage = productImage;
	}

	/**
	 * @return the productBrand
	 */
	public String getproductBrand() {
		return productBrand;
	}

	/**
	 * @param productBrand the productBrand to set
	 */
	public void setproductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	/**
	 * @return the productPrice
	 */
	public int getproductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setproductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productDiscount
	 */
	public int getproductDiscount() {
		return productDiscount;
	}

	/**
	 * @param productDiscount the productDiscount to set
	 */
	public void setproductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}
	/**
	 * @return the productQuantity
	 */
	public int getproductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setproductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	

}
