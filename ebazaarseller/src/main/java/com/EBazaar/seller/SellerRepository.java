package com.EBazaar.seller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository <SellerInfo, Integer> {


	//@Query(nativeQuery = true,value="Select * from participant where Skills like %:sname%")
	@Query(nativeQuery =true ,value="select * from seller_info where user_name like :user_name")
	Iterable<SellerInfo> findByuserName(String user_name);

	
	
	@Query(nativeQuery =true ,value="select * from seller_info where phone_number like :phone_number")
	Iterable<SellerInfo> findByPhoneNumber(String phone_number);
	
	
}
