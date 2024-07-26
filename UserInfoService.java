package com.EBazaar.UserInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository repo;

	// To get Information about all Users
	List<UserInfo> getAllUser() {

		return ((List) (repo.findAll()));

	}

	// To add new user
	void addNewUser(@RequestBody UserInfo user) {

		repo.save(user);
	}

	List<UserInfo> getUserByUserName(@PathVariable String name) {

		return repo.findByUserName(name);
	}
}
