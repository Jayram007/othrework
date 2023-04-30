package com.farmsystem.backend.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farmsystem.backend.entity.BuyerCart;
import com.farmsystem.backend.service.BuyerCartService;

@CrossOrigin
@RestController
@RequestMapping("/buyer-cart")
public class BuyerCartController 
{
	@Autowired
	BuyerCartService buyerCartService;
	
	@PostMapping("/add")
	public String regFarmer(@RequestBody BuyerCart cart) {
		String message = this.buyerCartService.addItem(cart);
		
		return message;
	}
	
	
	@PostMapping("/remove")
	public String removeItem(@RequestBody BuyerCart cart) {
		String message = this.buyerCartService.removeItem(cart);
		
		return message;
	}
	
}
