package com.app.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // table creation
@Table(name = "users")
public class Users extends BaseEntity {


	@NotEmpty
	@Size(min=4, max=100, message = "password must be within the range 4 to 15 characters")
	@Column(length = 100)
	private String password;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,10}$", message="firstName must be within the range 2 to 10 characters")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,10}$", message="lastName must be within the range 2 to 10 characters")
	@Column(name = "last_name")
	private String lastName;
	
	@Email
	@Column(unique = true)
	private String email;

	@Pattern(regexp = "^[0-9]{10,15}$", message="phone number must be within the range")
	@NotEmpty
	@Column(length = 15)
	private String phone;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,30}$", message="cityName must be within the range 2 to 30 characters")
	@Column(length = 30)
	private String city;

	@NotEmpty
	@Size(min=2, max=30, message = "state must be within the range 2 to 30 characters")
	@Column(length = 30)
	private String state;

	@NotEmpty
	@Size(min=2, max=10, message = "status must be within the range 2 to 10 characters")
	private String status = "Active";

	@NotEmpty
	@Size(min=2, max=20, message = "role must be within the range 2 to 20 characters")
	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Product> productlist;

	@OneToMany(mappedBy = "ouser", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<UserOrder> orderlist;

	@OneToMany(mappedBy = "crop", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<CropInfo> cropList;

	@OneToMany(mappedBy = "couser", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<CombineUserOrder> combineOrderlist;

	public List<CombineUserOrder> getCombineOrderlist() {
		return combineOrderlist;
	}

	public void setCombineOrderlist(List<CombineUserOrder> combineOrderlist) {
		this.combineOrderlist = combineOrderlist;
	}

	public List<CropInfo> getCropList() {
		return cropList;
	}

	public void setCropList(List<CropInfo> cropList) {
		this.cropList = cropList;
	}

	public List<UserOrder> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<UserOrder> orderlist) {
		this.orderlist = orderlist;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	@Override
	public String toString() {
		return "User ID: " + getId() + " [password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", role=" + role + ",city=" + city + ",state=" + state
				+ "]";
	}

}
