package com.zip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zip.dao.AdminInterfaceDao;
import com.zip.dao.BuyerInterfaceDao;
import com.zip.dao.SellerInterfaceDao;
import com.zip.entity.Buyer;
import com.zip.entity.Seller;

@Service
public class ServiceClass implements ServiceInterface {

   @Autowired
   private AdminInterfaceDao  aid;
   @Autowired
   private BuyerInterfaceDao bid;
   @Autowired
   private SellerInterfaceDao sid;
	
	@Override
	public String adminLoginService(String email, String password) {
		// TODO Auto-generated method stub
		aid.adminLoginDao(email, password);
		return null;
	}

	@Override
	public int buyerRegistrationService(Buyer buyer) {
		// TODO Auto-generated method stub
		bid.buyerRegistrationDao(buyer);
		return 0;
	}

	@Override
	public int buyerLoginService(Buyer buyer) {
		// TODO Auto-generated method stub
		bid.buyerLoginDao(buyer);
		return 0;
	}

	@Override
	public int sellerRegistrationService(Seller seller) {
		// TODO Auto-generated method stub
		sid.sellerRegistrationDao(seller);
		
		return 0;
	}

	@Override
	public int sellerLoginService(Seller seller) {
		// TODO Auto-generated method stub
		sid.sellerLoginDao(seller);
		return 0;
	}

}
