package com.EBazaar.bankaccountdetails;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EBazaar.UserInfo.UserInfo;
import com.EBazaar.UserInfo.UserInfoRepository;


@Service
public class BankAccountDetailsService {
	
	
	@Autowired
    private BankAccountDetailsRepository repo1;

    @Autowired
    private UserInfoRepository repo2;

    public BankAccountDetails createBankAccount(Integer bankId,Integer userId, Long accountNumber,String bankAccountType) {
        UserInfo userInfo = repo2.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BankAccountDetails bankAccount = new BankAccountDetails();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setUserInfo(userInfo);
        bankAccount.setBankAccountType(bankAccountType);
        bankAccount.setAccountNumber(accountNumber);

        return repo1.save(bankAccount);
    }

    List<BankAccountDetails> getAllAccount(){
    	
    	return ((List)repo1.findAll());
    }
    
    BankAccountDetails getAccountByBankId(Integer bankId) {
    	
    	return repo1.findById(bankId).get();
    }
    
    BankAccountDetails getAccountByAccountNumber(Long accountNumber) {
    	
    	return repo1.findByAccountNumber(accountNumber);
    }
    
    BankAccountDetails getAccountByUserName(String username) {
    	
    	return repo1.findByUserName(repo2.findByUserName(username));
    	
    }
    
    void updateAccount(BankAccountDetails account) {
    	
    	repo1.save(account);
    }
    
    
    

    
	
}
