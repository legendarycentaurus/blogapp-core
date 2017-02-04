package com.nanda.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nanda.dao.SeedCategoryDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.SeedCategory;
import com.nanda.validator.SeedCategoryValidator;

public class SeedCategoryService {

	private SeedCategoryValidator seedCategoryValidator = new SeedCategoryValidator();
	private SeedCategoryDao seedCategoryDao=new SeedCategoryDao();
	private final Logger logger = Logger.getLogger(SeedCategoryService.class.getName());

	public void save(SeedCategory SeedCategory) throws ServiceException {
		try {
			seedCategoryValidator.validateSave(SeedCategory);
			int rows=seedCategoryDao.save(SeedCategory);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	public void update(SeedCategory SeedCategory) throws ServiceException {
		try {
			seedCategoryValidator.validateUpdate(SeedCategory);
			int rows=seedCategoryDao.update(SeedCategory);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}
	
	public void delete(SeedCategory SeedCategory) throws ServiceException {
		try {
			seedCategoryValidator.validateDelete(SeedCategory);
			int rows=seedCategoryDao.delete(SeedCategory.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}	
}
	
	public List<SeedCategory> list(){
		return seedCategoryDao.list();
		
	}
}
