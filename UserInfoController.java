package com.EBazaar.UserInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EBazaar/api/v1.0")
public class UserInfoController {

	@Autowired
	UserInfoService service;

	@GetMapping("/allUsers")
	List<UserInfo> getAllUser() {

		return service.getAllUser();

	}

	@PostMapping("/addUser")
	void addnewUser(UserInfo user) {

		service.addNewUser(user);
	}

	List<UserInfo> getByUserName(String name) {

		return service.getUserByUserName(name);

	}

}
