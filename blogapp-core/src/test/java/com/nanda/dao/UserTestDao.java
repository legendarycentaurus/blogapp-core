package com.nanda.dao;

import java.util.List;

import com.nanda.exception.ServiceException;
import com.nanda.model.Role;
import com.nanda.model.User;
import com.nanda.service.UserService;

public class UserTestDao {
	public static void main(String[] args) throws ServiceException {
	
		User userObj=new User();
		UserService userServiceObj=new UserService();
		userObj.setName("aser");
		userObj.setPassword("aser");
		Role roleobj=new Role();
		roleobj.setId(2);
		userObj.setRoleId(roleobj);
		userObj.setEmailId("Adminemail");
		userServiceObj.signup(userObj);
		
		
		System.out.println(userServiceObj.login(userObj));
		
		userObj.setId(18);
		userObj.setPassword("pavan");
		userServiceObj.update(userObj);
		
		userObj.setId(20);
		userServiceObj.delete(userObj);
	
	
	List<User> u=userServiceObj.list();
	for(User ref:u)
		System.out.println(ref.getName()+"  "+ref.getPassword()+"  "+ref.getEmailId());

	List<User> ua=userServiceObj.listParticularUser(9);
	for(User ref:ua)
		System.out.println(ref.getName()+"  "+ref.getPassword()+"  "+ref.getEmailId());

	
	}
	


}
