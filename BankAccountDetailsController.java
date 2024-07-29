package com.EBazaar.bankaccountdetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BankAccountDetailsController {

	@Autowired
	BankAccountDetailsService service;

	
	@PostMapping("/createaccount")
	BankAccountDetails createBankAccount(@PathVariable Integer bankId,Integer userId, Long accountNumber,String bankAccountType) {

		return service.createBankAccount(bankId, userId, accountNumber, bankAccountType);

	}

	@GetMapping("/allaccounts")
	List<BankAccountDetails> getAllAccount() {

		return service.getAllAccount();
	}

	@GetMapping("/id/{id}")
	BankAccountDetails getAccountByBankId(@PathVariable Integer bankId) {

		return service.getAccountByBankId(bankId);
	}

	@GetMapping("/accountnumber/{accountNumber}")
	BankAccountDetails getAccountByAccountNumber(Long accountNumber) {

		return service.getAccountByAccountNumber(accountNumber);
	}

	@GetMapping("/username/{username}")
	BankAccountDetails getAccountByUserName(String username) {

		return service.getAccountByUserName(username);

	}
	
	@PutMapping("/update")
	 void  updateAccount(BankAccountDetails account) {
	    	
	    	service.updateAccount(account);
	    }

}
