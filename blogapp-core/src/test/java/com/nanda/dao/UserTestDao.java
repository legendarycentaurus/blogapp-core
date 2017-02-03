package com.nanda.dao;

import com.nanda.exception.ServiceException;
import com.nanda.model.Role;
import com.nanda.model.User;
import com.nanda.service.UserService;

public class UserTestDao {
	public static void main(String[] args) throws ServiceException {
	
		UserDao userDaoObj=new UserDao();
		User userObj=new User();
		UserService userServiceObj=new UserService();
		userObj.setName(" Ragav");
		userObj.setPassword("jas");
		Role roleobj=new Role();
		roleobj.setId(2);
		userObj.setRoleId(roleobj);
		userObj.setEmailId("Ragavemail");
		
		//userServiceObj.signup(userObj);
		System.out.println(userServiceObj.login(userObj));
		
		userObj.setId(589);
		userObj.setPassword("pavan");
		userServiceObj.update(userObj);
		
		userObj.setId(6);
		userServiceObj.delete(userObj);
	
	
	userDaoObj.list();
	userDaoObj.listParticularUser(9);
	
	}
	
	
	
}
