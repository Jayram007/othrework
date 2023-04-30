package com.farmsystem.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	FarmerRepo farmerRepo ;
	
	@Autowired
	BuyerRepo buyerRepo;

	@Override
	public String updateFarmerProfile(String username, Farmer farmer) {
		System.out.println(username);
		
		System.out.println(farmer.getAddress());
		if(farmer.getFirstname()!= "")
		{
			farmerRepo.updateFirstName(farmer.getFirstname(),username);
		}
		if(farmer.getLastname()!= "")
		{
			farmerRepo.updateLastName(farmer.getLastname(), username);
		}
		if(farmer.getContact()!="")
		{
			farmerRepo.updateContact(farmer.getContact(), username);
		}
		if(farmer.getEmail()!= "")
		{
			farmerRepo.updateEmail(farmer.getEmail(), username);
		}
		if(farmer.getAddress()!= "")
		{
			farmerRepo.updateAddress(farmer.getAddress(), username);
		}
		if(farmer.getPassword()!= "")
		{
			farmerRepo.updatePassword(farmer.getPassword(), username);
		}
		
		return "updated";
	}

	@Override
	public String updateBuyerProfile(String username, Buyer buyer) {
		System.out.println(username);
		
		System.out.println(buyer.getAddress());
		if(buyer.getFirstname()!= "")
		{
			buyerRepo.updateFirstName(buyer.getFirstname(),username);
		}
		if(buyer.getLastname()!= "")
		{
			buyerRepo.updateLastName(buyer.getLastname(), username);
		}
		if(buyer.getContact()!="")
		{
			buyerRepo.updateContact(buyer.getContact(), username);
		}
		if(buyer.getEmail()!= "")
		{
			buyerRepo.updateEmail(buyer.getEmail(), username);
		}
		if(buyer.getAddress()!= "")
		{
			buyerRepo.updateAddress(buyer.getAddress(), username);
		}
		if(buyer.getPassword()!= "")
		{
			buyerRepo.updatePassword(buyer.getPassword(), username);
		}
		
		return "updated";
	}

}
