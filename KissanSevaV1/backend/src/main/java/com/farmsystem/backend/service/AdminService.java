package com.farmsystem.backend.service;

import java.util.List;

import com.farmsystem.backend.entity.Admin;
import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;

public interface AdminService {
	
	String adminLogin(Admin admin);
	
	List<Buyer>getAllBuyers();
	
	List<Farmer>getAllFarmers();
	
	List<Order>getAllOrders();
	
	List<Product>getAllProducts();
	
	void deleteBuyerByid(Integer id);
	
	void deleteFarmerByid(Integer id);

	
}
