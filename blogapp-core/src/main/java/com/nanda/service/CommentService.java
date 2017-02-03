package com.nanda.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.nanda.dao.CommentDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.Comment;
import com.nanda.validator.CommentValidator;

public class CommentService {

	private CommentValidator CommentValidator = new CommentValidator();
	private CommentDao CommentDao=new CommentDao();
	private final Logger logger = Logger.getLogger(CommentService.class.getName());

	public void save(Comment Comment) throws ServiceException {
		try {
			CommentValidator.validateSave(Comment);
			int rows=CommentDao.save(Comment);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	
	public void delete(Comment Comment) throws ServiceException {
		try {
			CommentValidator.validateDelete(Comment);
			int rows=CommentDao.delete(Comment.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}
	
	
}
