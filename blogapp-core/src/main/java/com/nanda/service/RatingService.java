package com.nanda.service;

import java.util.List;

import com.nanda.dao.RatingDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.Rating;
import com.nanda.validator.RatingValidator;

public class RatingService {

	private RatingValidator ratingValidator = new RatingValidator();
	private RatingDao ratingDao=new RatingDao();

	public void save(Rating Rating) throws ServiceException {
		try {
			ratingValidator.validateSave(Rating);
			ratingDao.save(Rating);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	public void update(Rating Rating) throws ServiceException {
		try {
			ratingValidator.validateUpdate(Rating);
			ratingDao.update(Rating);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}
	
	public void delete(Rating Rating) throws ServiceException {
		try {
			ratingValidator.validateDelete(Rating);
		ratingDao.delete(Rating.getId());
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
