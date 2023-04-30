package com.farmsystem.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmsystem.backend.entity.BuyerCart;
import com.farmsystem.backend.repository.BuyerCartRepo;
import com.farmsystem.backend.repository.ProductRepo;
import com.farmsystem.backend.service.BuyerCartService;

@Service
public class BuyerCartServiceImpl implements BuyerCartService {
	
	@Autowired
	BuyerCartRepo buyercartRepo ;
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public String addItem(BuyerCart cart) {
		buyercartRepo.save(cart);
		return  "added_successfully";
	}

	@Override
	public String removeItem(BuyerCart cart) {
		 buyercartRepo.deleteById(cart.getCartid());
		 return  "deleted_successfully"; 
	}

}
