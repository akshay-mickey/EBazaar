package com.EBazaar.seller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

	 @Autowired
	SellerRepository repo;
	 
	 
	 public void getSellerDetails(SellerInfo sellerInfo) {
		 repo.save(sellerInfo);
	 }


	public Iterable<SellerInfo> getAllSellers() {
		return repo.findAll();
	}


	public Iterable<SellerInfo> getSellerInfoByuserName(String userName) {
		return repo.findByuserName(userName);
	}


	public Iterable<SellerInfo> getSellerInfoByPhontNumber(String phoneNumber) {
		return repo.findByPhoneNumber(phoneNumber);
	}


	public void deleteBySellerId(Integer id) {
		repo.deleteById(id);
		
	}


	public void updatetSeller(SellerInfo sellerInfo) {
		repo.save(sellerInfo);
	}


	
		
	
	
}
