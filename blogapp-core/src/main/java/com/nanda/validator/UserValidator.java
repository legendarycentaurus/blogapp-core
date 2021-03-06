package com.nanda.validator;

import com.nanda.exception.ValidationException;
import com.nanda.model.User;
import com.nanda.util.ValidationUtil;

public class UserValidator {

	private void validateUser(User user) throws ValidationException {
		ValidationUtil.isNotValid(user,"Invalid User");
	}
	
	private void validateId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid Id");
	}
	
	
	private void validateName(String name)throws ValidationException{
		ValidationUtil.isNotValid(name,"Invalid Name");
	}
	
	private void validateUserName(String username)throws ValidationException{
		ValidationUtil.isNotValid(username,"Invalid UserName");
	}
	
	private void validatePassword(String password)throws ValidationException{
		ValidationUtil.isNotValid(password,"Invalid Password");
	}
	
	
	private void validateEmailId(String emailId)throws ValidationException{
		ValidationUtil.isNotValid(emailId,"Invalid EmailID");
	}
	
	public void validateSave(User user) throws ValidationException{
		validateUser(user);
		validateName(user.getName());
		validatePassword(user.getPassword());
		validateEmailId(user.getEmailId());
			}
	
	public void validateLogin(User user) throws ValidationException{
		validateUser(user);
		validateUserName(user.getName());
		validatePassword(user.getPassword());
		
	}
	
	public void validateUpdate(User user) throws ValidationException{
		validateUser(user);
		validateUserName(user.getName());
		validatePassword(user.getPassword());
	}
	
	public void validateDelete(User user) throws ValidationException{
		validateUser(user);
		validateId(user.getId());
		
	}
	public void validateRoleByAdmin(User user) throws ValidationException{
		validateUser(user);
		validateId(user.getId());
		validateId(user.getRoleId().getId());
	}

	
}
