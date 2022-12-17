package com.jbk.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "product_tble")
public class Product {

	@Id
  //@Column(name = "pId") if we wanna change the name of a column
	private String productId;
	
   //@Column (nullable = false) it will be not null
	
	@NotNull(message = "ProductName is Required")
	private String productName;
	
	@Min(1)
	private int productQty;
	
	@Min(1)
	private double productPrice;
	
	@NotNull(message= "ProductType is Required")
	private String productType;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, int productQty, double productPrice, String productType) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.productType = productType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQty=" + productQty
				+ ", productPrice=" + productPrice + ", productType=" + productType + "]";
	}

}
