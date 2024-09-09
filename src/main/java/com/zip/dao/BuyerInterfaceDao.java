package com.zip.dao;

import com.zip.entity.Buyer;

public interface BuyerInterfaceDao {
	int buyerRegistrationDao(Buyer buyer);
	int buyerLoginDao(Buyer buyer);
}
