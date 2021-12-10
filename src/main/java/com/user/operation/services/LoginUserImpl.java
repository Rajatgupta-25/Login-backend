package com.user.operation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.operation.dao.LoginDao;
import com.user.operation.entities.Login;

@Service
public class LoginUserImpl implements LoginUserService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public String isValidUser(Login loginInfo) {
		String str="";
		boolean flag = false;
		boolean employee = false;
		List<Login> list = loginDao.findAll();
		for(Login l : list) {
			if(l.getUserEmail().equals(loginInfo.getUserEmail()) && l.getUserPassword().equals(loginInfo.getUserPassword()))
			{		
				flag = true;
				if(l.getRole().equals("employee"))
					employee=true;
				break;
			}
		}
		if(flag) {
			if(employee)
				str = "Valid,employee";
			else
				str = "Valid,manager";
		}
		else
			str = "notValid";
		return str;
	}

}
