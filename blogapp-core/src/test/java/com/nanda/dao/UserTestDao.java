package com.nanda.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nanda.config.AppConfig;
import com.nanda.exception.ServiceException;
import com.nanda.model.Role;
import com.nanda.model.User;
import com.nanda.service.UserService;

public class UserTestDao {
	public static void main(String[] args) throws ServiceException {
	
		User userObj=new User();
		//UserService userServiceObj=new UserService();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userServiceObj  = ctx.getBean(UserService.class);
		userObj.setName("naresh");
		userObj.setPassword("naresh");
		Role roleobj=new Role();
		roleobj.setId(2);
		userObj.setRoleId(roleobj);
		userObj.setEmailId("nareshemail");
		userServiceObj.signup(userObj);
		
//		
//		System.out.println(userServiceObj.login(userObj));
//		
//		userObj.setId(18);
//		userObj.setPassword("pavan");
//		userServiceObj.update(userObj);
//		
//		userObj.setId(20);
//		userServiceObj.delete(userObj);
//	
//	
//	List<User> u=userServiceObj.list();
//	for(User ref:u)
//		System.out.println(ref.getName()+"  "+ref.getPassword()+"  "+ref.getEmailId());
//
//	User ua=userServiceObj.listParticularUser("james");
//
//		System.out.println(ua);

	
	}
	


}
