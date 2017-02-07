package com.nanda.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nanda.dao.RatingDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.Rating;
import com.nanda.validator.RatingValidator;

public class RatingService {

	private RatingValidator ratingValidator = new RatingValidator();
	private RatingDao ratingDao=new RatingDao();
	private final Logger logger = Logger.getLogger(RatingService.class.getName());

	public void save(Rating Rating) throws ServiceException {
		try {
			ratingValidator.validateSave(Rating);
			int rows=ratingDao.save(Rating);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	public void update(Rating Rating) throws ServiceException {
		try {
			ratingValidator.validateUpdate(Rating);
			int rows=ratingDao.update(Rating);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}
	
	public void delete(Rating Rating) throws ServiceException {
		try {
			ratingValidator.validateDelete(Rating);
			int rows=ratingDao.delete(Rating.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}
	
	public List<Rating> list(int userId)throws ServiceException{
		try {
			ratingValidator.validateUser(userId);
		} catch (ValidationException e) {
			throw new ServiceException("No Ratings found");
		}
		return ratingDao.list(userId);
	}
}
