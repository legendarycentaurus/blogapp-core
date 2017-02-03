package com.nanda.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.nanda.dao.RatingDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.Rating;
import com.nanda.validator.RatingValidator;

public class RatingService {

	private RatingValidator RatingValidator = new RatingValidator();
	private RatingDao RatingDao=new RatingDao();
	private final Logger logger = Logger.getLogger(RatingService.class.getName());

	public void save(Rating Rating) throws ServiceException {
		try {
			RatingValidator.validateSave(Rating);
			int rows=RatingDao.save(Rating);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	public void update(Rating Rating) throws ServiceException {
		try {
			RatingValidator.validateUpdate(Rating);
			int rows=RatingDao.update(Rating);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}
	
	public void delete(Rating Rating) throws ServiceException {
		try {
			RatingValidator.validateDelete(Rating);
			int rows=RatingDao.delete(Rating.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}
	
	
}
