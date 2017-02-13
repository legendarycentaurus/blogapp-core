package com.nanda.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.EmailException;

import com.nanda.dao.CommentDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.Comment;
import com.nanda.validator.CommentValidator;

public class CommentService {

	private CommentValidator CommentValidator = new CommentValidator();
	private CommentDao CommentDao=new CommentDao();
	private final Logger logger = Logger.getLogger(CommentService.class.getName());

	public void save(Comment comment) throws ServiceException,EmailException {
		try {
			CommentValidator.validateSave(comment);
			int rows=CommentDao.save(comment);
			logger.log(Level.SEVERE, "You have made Comment: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Comment",e);
		}
		catch (EmailException e) {
			throw new ServiceException("Unable to send Mail",e);
		}
	}

	
	public void delete(Comment comment) throws ServiceException {
		try {
			CommentValidator.validateDelete(comment);
			int rows=CommentDao.delete(comment.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}
	public List<Comment> list(int id){
		return CommentDao.list(id);
	
		}

	
}
