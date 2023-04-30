package com.farmsystem.backend.service;

import java.util.List;
import java.util.Optional;

import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.BuyerCart;
import com.farmsystem.backend.entity.Order;
import com.farmsystem.backend.entity.Product;

public interface BuyerService {
	
	String buyerLogin(Buyer buyer);
	
	String registerBuyer(Buyer buyer);
	
	List<Product> getProductByCrop(Product prod);
	
	List<Product>getAllProducts();
	
	List<BuyerCart>getBuyerCart();
	
	List<Order>ConfirmOrders(Buyer buyer);
	
	String addOrder(Order order);
	
	Buyer getBuyers(String username);

}
