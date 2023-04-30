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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity // table creation
@Table(name = "userorder")
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,30}$", message="productName must be within the range 2 to 30 characters")
	@Column(length = 30)
	private String productName;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private float itemsPrice;

	@NotNull
	@Digits(integer = 5, fraction = 2)
	private float taxPrice;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private float shippingPrice;

	@NotNull
	@Digits(integer = 5, fraction = 2)
	private float totalPrice;

	@NotEmpty
	@Size(min=2, max=10, message = "status must be within the range 2 to 10 characters")
	private String status = "Order Placed";

//	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id")
	private Users ouser;

	public Users getOuser() {
		return ouser;
	}

	public void setOuser(Users ouser) {
		this.ouser = ouser;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getItemsPrice() {
		return itemsPrice;
	}

	public void setItemsPrice(float itemsPrice) {
		this.itemsPrice = itemsPrice;
	}

	public float getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(float taxPrice) {
		this.taxPrice = taxPrice;
	}

	public float getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(float shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int o_Id) {
		oid = o_Id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
