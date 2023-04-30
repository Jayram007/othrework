package com.farmsystem.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;

public interface FarmerService {
	
	
	Farmer getFarmer(String username);
	
	String forgotPassword(Farmer farmer);
	
	String regFarmer(Farmer farmer);
	
	String loginUser(Farmer farmer);
	
	List<Order> getDetailsByFarmer(Farmer farmer);
	
	String addProduct(Product product);
	
	String getOrder(Order order);
	
	
	
	

}
