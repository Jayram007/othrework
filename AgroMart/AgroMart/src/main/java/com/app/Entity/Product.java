package com.app.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@NotEmpty
	@Size(min=2, max=30, message = "product Name must be within the range 2 to 30 characters")
	private String productName;
	
	@NotEmpty
	@Size(min=2, max=30, message = "categories must be within the range 2 to 30 characters")
	private String categories;
	
	@NotNull
	@Digits(integer = 5, fraction = 0)
	private int stocks;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private float price;

	@Column(length = 1000, name = "image_name")
	private String imageName;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id")
	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int p_Id) {
		pid = p_Id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return String.format("Product [P_Id=%s, productName=%s, categories=%s,stocks=%s, price=%s, imageName=%s]", pid,
				productName, categories, stocks, price, imageName);
	}
}
