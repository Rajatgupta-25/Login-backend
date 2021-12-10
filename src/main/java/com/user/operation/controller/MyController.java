package com.user.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.operation.entities.Login;
import com.user.operation.services.LoginUserService;

@RestController
@CrossOrigin(origins = "*")
public class MyController {
	@Autowired
	private LoginUserService loginUserService;
	
	//check login details
	@PostMapping("/login")
	public String checkLogin(@RequestBody Login loginInfo) {
		return loginUserService.isValidUser(loginInfo);
	}
}
