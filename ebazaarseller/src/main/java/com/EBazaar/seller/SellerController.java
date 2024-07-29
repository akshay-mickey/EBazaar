package com.EBazaar.seller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller/v1.0")
public class SellerController {

	@Autowired
	SellerService service;

	@GetMapping("/")
	String Greeting() {
		return "Welcome to seller page";
	}

	@PostMapping("/addSeller/")
	void getSellerDetails(@RequestBody SellerInfo sellerInfo) {
		service.getSellerDetails(sellerInfo);
	}
	
	@PutMapping("/addSeller/{id}")
	void updaetSeller(@RequestBody SellerInfo sellerInfo) {
		service.updatetSeller(sellerInfo);
	}
	
	@GetMapping("/allSellers")
	Iterable<SellerInfo> getAllSellers() {
     	return service.getAllSellers();
}
	@GetMapping("/displayByUserName/{userName}")
	Iterable<SellerInfo> getSellerInfoByUserName(@PathVariable String userName)
	{
		return service.getSellerInfoByuserName(userName);
	}
	
	@GetMapping("/displayByPhoneNumber/{phoneNumber}")
	Iterable<SellerInfo> getSellerInfoByPhonrNmumber(@PathVariable String phoneNumber)
	{
		return service.getSellerInfoByPhontNumber(phoneNumber);
	}
	
	@GetMapping("deleteBySellerId/{id}")
	void deleteBySellerId(@PathVariable Integer id) {
		service.deleteBySellerId(id);
	}

}