package com.farmsystem.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmsystem.backend.entity.Admin;
import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.repository.AdminRepo;
import com.farmsystem.backend.repository.BuyerCartRepo;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.AdminService;



@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	AdminService adminservice;
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Admin admin) {
		
	  String message = this.adminservice.adminLogin(admin);
	  
	  return message;
	}
	
	
	@GetMapping("/buyer-list")
	public List<Buyer> getBuyers() {
	        
		List<Buyer> buyerList = this.adminservice.getAllBuyers();

		return buyerList;
	}
	
	@GetMapping("/farmer-list")
	public List<Farmer> getFarmers() {
	        
		
		List<Farmer> farmerList = this.adminservice.getAllFarmers();              
			
		return farmerList;
	}
	
	@GetMapping("/Orders")
	public List<Order> getOrders() {
	        
		
		List<Order> orderList = this.adminservice.getAllOrders();              
			
		return orderList;
	}
	
	@GetMapping("/Product")
	public List<Product> getProduct() {
	        
		List<Product> productList = this.adminservice.getAllProducts();              
			
		return productList;
	}
	
	@DeleteMapping("/delFarmer/{id}")
	public  String deleteFarmer(@PathVariable Integer id)
	{
		adminservice.deleteFarmerByid(id);
		return "farmer deleted ";
	}
	
	@DeleteMapping("/delBuyer/{id}")
	public  String deleteBuyer(@PathVariable Integer id)
	{
		adminservice.deleteBuyerByid(id);
		return "buyer deleted ";
	}

	
	
	
}
