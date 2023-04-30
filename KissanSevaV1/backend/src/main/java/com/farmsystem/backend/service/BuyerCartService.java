package com.farmsystem.backend.service;

import com.farmsystem.backend.entity.BuyerCart;

public interface BuyerCartService {
	
	String addItem(BuyerCart cart);
	
	String removeItem(BuyerCart cart);
	
	

}
