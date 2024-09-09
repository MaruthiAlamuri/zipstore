package com.zip.service;

import com.zip.entity.Buyer;
import com.zip.entity.Seller;

public interface ServiceInterface {

	
	String adminLoginService(String email,String password);
	 
	int buyerRegistrationService(Buyer buyer);
	int buyerLoginService(Buyer buyer);

	int sellerRegistrationService(Seller seller);

	int sellerLoginService(Seller seller);
}
