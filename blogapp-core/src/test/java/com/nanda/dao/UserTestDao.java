package com.nanda.dao;

import com.nanda.exception.ServiceException;
import com.nanda.model.User;
import com.nanda.service.UserService;

public class UserTestDao {
	public static void main(String[] args) throws ServiceException {
	
		UserDao userDaoObj=new UserDao();
		User userObj=new User();
		UserService userServiceObj=new UserService();
//		userObj.setName(" Pavan");
//		userObj.setPassword("james");
//		userObj.setEmailId("pavanemail");
//		userServiceObj.signup(userObj);
//
//		
//		userObj.setId(589);
//		userObj.setPassword("pavan");
//		userServiceObj.update(userObj);
//		
		userObj.setId(6);
		userServiceObj.delete(userObj);
	
	
	userDaoObj.list();
	userDaoObj.listParticularUser(9);
	}
	
	
	
}
