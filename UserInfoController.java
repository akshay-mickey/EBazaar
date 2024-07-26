package com.EBazaar.UserInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	void addnewUser(@RequestBody UserInfo user) {

		service.addNewUser(user);
	}

	@GetMapping("/username/{name}")
	List<UserInfo> getByUserName(@PathVariable String name) {

		return service.getUserByUserName(name);

	}

}
