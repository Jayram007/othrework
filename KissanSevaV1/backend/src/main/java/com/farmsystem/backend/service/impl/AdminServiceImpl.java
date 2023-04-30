package com.farmsystem.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmsystem.backend.entity.Admin;
import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;
import com.farmsystem.backend.repository.AdminRepo;
import com.farmsystem.backend.repository.BuyerRepo;
import com.farmsystem.backend.repository.FarmerRepo;
import com.farmsystem.backend.repository.OrderRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	BuyerRepo buyerRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	FarmerRepo farmerRepo;

	@Override
	public String adminLogin(Admin admin) {
		//System.out.println(admin.getPassword());
		//System.out.println(admin.getUser_name());
		List<Admin> adminList = adminRepo.findAll();              
		
		String passMsg = "pass" ;
		String failMsg = "fail" ;
		
		for(Admin adminobj : adminList )
		{
		if(adminobj.getUser_name().equals(admin.getUser_name()) && adminobj.getPassword().equals(admin.getPassword()))
			{
				
				return passMsg ;
			}
		}
	
	return failMsg;
	}
	

	@Override
	public List<Buyer> getAllBuyers() {
		List<Buyer> buyerList = buyerRepo.findAll();
		return buyerList;
	}
	

	@Override
	public List<Farmer> getAllFarmers() {
		List<Farmer> farmerList = farmerRepo.findAll();              
		return farmerList;
	}
	

	@Override
	public List<Order> getAllOrders() {
		List<Order> farmerList = orderRepo.findAll();              
		
		return farmerList;
	}

	
	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productRepo.findAll();              
		
		return productList;
	}
	
	@Override
	public void deleteBuyerByid(Integer id)
	{
		buyerRepo.deleteById(id);
	}
	
	@Override
	public void deleteFarmerByid(Integer id)
	{
		farmerRepo.deleteById(id);
	}


}
