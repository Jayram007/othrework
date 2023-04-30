package com.farmsystem.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.repository.BuyerCartRepo;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.ProfileService;

@CrossOrigin
@RestController
@RequestMapping("change-profile")
public class ProfileController 
{
	@Autowired
	ProfileService profileService ;
	
	
	
	@PostMapping("farmer/{username}")
	public String updateFarmerProfile(@PathVariable String username,@RequestBody Farmer farmer)
	{
		String message = this.profileService.updateFarmerProfile(username,farmer);
		
		return message;
	}
	
	@PostMapping("buyer/{username}")
	public String updateBuyerProfile(@PathVariable String username,@RequestBody Buyer buyer)
	{
		String message = this.profileService.updateBuyerProfile(username,buyer);
		
		return message;
	}
}
