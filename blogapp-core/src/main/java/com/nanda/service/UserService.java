package com.nanda.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DuplicateKeyException;

import com.nanda.dao.UserDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.User;
import com.nanda.validator.UserValidator;
public class UserService {
	
	private UserValidator userValidator = new UserValidator();
	private UserDao userDao=new UserDao();
	private final Logger logger = Logger.getLogger(UserValidator.class.getName());
	public void signup(User user) throws ServiceException,DuplicateKeyException {
		try {
			userValidator.validateSave(user);
			int rows=userDao.save(user);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
		catch(DuplicateKeyException e){
			throw new DuplicateKeyException("Register failed",e);
		}
	}

	
	public Integer login(User user) throws ServiceException {
		try {
			userValidator.validateLogin(user);
			return userDao.login(user);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Login",e);
		}
	}
	public Integer roleByAdmin(User user) throws ServiceException {
		try {
			userValidator.validateUpdate(user);
			return userDao.roleByAdmin(user);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Update",e);
		}
	}

	
	public Integer update(User user) throws ServiceException {
		try {
			userValidator.validateUpdate(user);
			return userDao.update(user);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Update",e);
		}
	}
	
	public void delete(User user) throws ServiceException {
		try {
			userValidator.validateDelete(user);
			int rows=userDao.delete(user.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}
	
	public List<User> list(){
		return userDao.list();
	}

	public User listParticularUser(String Name){
		return userDao.listParticularUser(Name);
	}
	
}
