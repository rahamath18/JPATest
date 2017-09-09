package com.test.jpa.entity;

import javax.persistence.*;

/**
* @author Deepak Kumar
* More tutorials at http://www.roseindia.net
*/

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="stock_qty")
	private Double stockQty;
	
	@Column(name="price")
	private Double price;
	
	public Product(){}
	

	public Product(int id, String productName, String productDescription, Double stockQty, Double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.stockQty = stockQty;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getStockQty() {
		return stockQty;
	}

	public void setStockQty(Double stockQty) {
		this.stockQty = stockQty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

}