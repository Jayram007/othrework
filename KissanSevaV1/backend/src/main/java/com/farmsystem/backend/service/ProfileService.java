package com.farmsystem.backend.service;

import com.farmsystem.backend.entity.Buyer;
import com.farmsystem.backend.entity.Farmer;

public interface ProfileService {
	
	String updateFarmerProfile(String username,Farmer farmer);
	
	String updateBuyerProfile(String username,Buyer buyer);

}
