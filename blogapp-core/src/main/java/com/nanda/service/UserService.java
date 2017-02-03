package com.nanda.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.nanda.dao.UserDao;
import com.nanda.validator.UserValidator;
import com.nanda.model.User;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
public class UserService {
	
	private UserValidator userValidator = new UserValidator();
	private UserDao userDao=new UserDao();
	private final Logger logger = Logger.getLogger(UserValidator.class.getName());
	public void signup(User user) throws ServiceException {
		try {
			userValidator.validateSave(user);
			int rows=userDao.save(user);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	public void update(User user) throws ServiceException {
		try {
			userValidator.validateUpdate(user);
			int rows=userDao.update(user);
			logger.log(Level.SEVERE, "Values are updated: %d",rows);
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
	
	

	
	
}
