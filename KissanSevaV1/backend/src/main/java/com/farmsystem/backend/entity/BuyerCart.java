package com.farmsystem.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="buyercart")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class BuyerCart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartid")
	private int cartid;
	
	@NotEmpty
	@Column(name="buyerusername")
	private String buyerusername;
	
	@NotEmpty
	@Column(name="crop")
	private String crop;
	
	
	@Column(name="quantity")
	private double quantity;
	
	
	@Column(name="expectedprice")
	private double expectedprice;
	
	@NotEmpty
	@Column(name="farmername")
	private String farmername;
	
	
	
}
