package com.farmsystem.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.exceptions.ResourceNotFoundException;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.FarmerService;

@Service
public class FarmerServiceImpl implements FarmerService{
	
	@Autowired
	FarmerRepo farmerRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public Farmer getFarmer(String username) {
		
		//System.out.println("im here");
		
		int fid = farmerRepo.findByName(username);
		
		Farmer farmer = farmerRepo.findById(fid).orElseThrow(()-> new ResourceNotFoundException("farmer", "Id", fid));
        
		return farmer;
	}

	@Override
	public String forgotPassword(Farmer farmer) {
		String username = farmer.getUser_name();
		String newpassword = farmer.getPassword();
		
		farmerRepo.updatePassword(newpassword,username);
		
		return "updated";
	}

	@Override
	public String regFarmer(Farmer farmer) {
		System.out.println(farmer.toString());
	     String email = farmer.getEmail();
	     
	     EmailServiceImpl.sendMail(email);
	     
	     
		farmerRepo.save(farmer);
		     
		return "register_success";
	}

	@Override
	public String loginUser(Farmer farmer) {
		System.out.println(farmer.getUser_name());
		
		List<Farmer> farmerList = farmerRepo.findAll();              
		
		String passMsg = "pass" ;
		String failMsg = "fail" ;
		
		for(Farmer farmerobj : farmerList )
		{
		if(farmerobj.getUser_name().equals(farmer.getUser_name()) && farmerobj.getPassword().equals(farmer.getPassword()))
			{
				
				return passMsg ;
			}
		}
	
	    return failMsg;
	}

	@Override
	public List<Order> getDetailsByFarmer(Farmer farmer) {
		String uname = farmer.getUser_name();
		
		int fid = farmerRepo.findByName(uname);
		
		List<Order> orderList = orderRepo.findById(fid);  
		
		return orderList;
	}

	@Override
	public String addProduct(Product product) {
		System.out.println(product.getCrop());
		String uname = product.getFarmer().getUser_name();
		
		int fid = farmerRepo.findByName(uname);
		
		product.getFarmer().setFid(fid);
		
		productRepo.save(product);
	     
	    return "register_success";
	}

	@Override
	public String getOrder(Order order) {
		System.out.println(order.getOid());
		
		int oid = order.getOid();
		
		int fid = order.getFarmer().getFid();
		
		String crop = order.getCrop_category();
		
		double quantityAvailable = productRepo.getQuantity(fid,crop);
		
		double quatitytOrdered = order.getQuantity();
		
		double quantityRemains = (quantityAvailable)-(quatitytOrdered);
		
		if(quantityRemains == 0)
		{
			productRepo.deleteQuantityCompletly(fid,crop);
		}
		else
		{
			productRepo.deductQuantity(fid,quantityRemains,crop);
		}
				
		orderRepo.changeStatus(oid);
	     
	    return "approved successfully";
	}

}
