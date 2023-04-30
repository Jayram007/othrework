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

import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.BuyerCart;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.repository.BuyerCartRepo;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.BuyerService;

@CrossOrigin
@RestController
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Buyer buyer) {
	        
		String message = this.buyerService.buyerLogin(buyer);
			
		return message;
	}
	
	
	
	@PostMapping("/Registration")
	public String regBuyer(@Valid @RequestBody Buyer buyer) {
		
		String message = this.buyerService.registerBuyer(buyer);
		     
		return message;  
		    
	}
	
	@PostMapping("/search")
	public List<Product> searchProduct(@RequestBody Product prod) {
	        
		List<Product> productList = this.buyerService.getProductByCrop(prod);              
		
		return productList;
	}
	
	
	
	@PostMapping("/allsearch")
	public List<Product> searchProduct() {
	        	
		List<Product> productList = this.buyerService.getAllProducts();              
		
		return productList;
	}
	
	
	@PostMapping("/myCart")
	public List<BuyerCart> buyerCart() {
	        
		List<BuyerCart> cartlist = this.buyerService.getBuyerCart();              
		
		return cartlist;
	}
	
	
	
	//http://localhost:9099/buyer/confirmed-orders
		
	@PostMapping("/confirmed-orders")
	public List<Order> buyerCart(@RequestBody Buyer buyer) {
	        
		List<Order> orderList = this.buyerService.ConfirmOrders(buyer);  
			
		return orderList;
		
	}
		
	@PostMapping("/addOrder")
	public String addOrders(@RequestBody Order order) {
				
		String message = this.buyerService.addOrder(order);	
		
		return message;
	}
		
	
	@GetMapping("/profile/{username}")
	public Buyer getBuyer(@PathVariable String username) {
			
		Buyer buyer =this.buyerService.getBuyers(username);
				          
		return buyer;
			    
	}
		
}
