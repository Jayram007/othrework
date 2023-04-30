package com.farmsystem.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.FarmerService;

@CrossOrigin
@RestController
@RequestMapping("/farmer")
public class FarmerController 
{
	@Autowired
	FarmerService farmerService;
	
	@GetMapping("/profile/{username}")
	public Farmer getFarmer(@PathVariable String username) {
		
		Farmer farmer = this.farmerService.getFarmer(username);
		
		return farmer;    
	}
	
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody Farmer farmer)
	{
		String message = this.farmerService.forgotPassword(farmer);
		
		return message;
	}
	
	
	
	@PostMapping("/Registration")
	public String regFarmer(@Valid @RequestBody Farmer farmer) {

		String message = this.farmerService.regFarmer(farmer);
		  
		return message;
	}
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Farmer farmer) {
	     
		String message = this.farmerService.loginUser(farmer);
			
		return message;
	}
	
	
	@PostMapping("/orders")
	public List<Order> getDetails(@RequestBody Farmer farmer)
	{
		List<Order> orderList =this.farmerService.getDetailsByFarmer(farmer);
		
		return orderList;
		
	}
	
	
	
	@PostMapping("/add-product")
	public String addProducts(@RequestBody Product product)
	{
		String message = this.farmerService.addProduct(product);
		
		return message;
		
	}
	
	@PostMapping("/orders/change-status")
	public String getOrder(@RequestBody Order order)
	{
		System.out.println("im here");
		String message = this.farmerService.getOrder(order);
		
		return message;
		
	}
	
}
