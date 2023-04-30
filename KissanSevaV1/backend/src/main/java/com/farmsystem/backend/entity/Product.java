package com.farmsystem.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private int pid;
	
	@ManyToOne
	@JoinColumn(name="fid")
	private Farmer farmer;
	
	@NotEmpty
	@Column(name= "crop")
	private String crop;
	

	@Column(name= "quantity")
	private double quantity;
	
	
	@Column(name= "expected_Price")
	private double expected_Price;

	
}
