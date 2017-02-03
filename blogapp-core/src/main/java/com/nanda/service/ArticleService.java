package com.nanda.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.nanda.dao.ArticleDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.Article;
import com.nanda.validator.ArticleValidator;
public class ArticleService {

	private ArticleValidator articleValidator = new ArticleValidator();
	private ArticleDao articleDao=new ArticleDao();
	private final Logger logger = Logger.getLogger(ArticleService.class.getName());

	public void save(Article article) throws ServiceException {
		try {
			articleValidator.validateSave(article);
			int rows=articleDao.save(article);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	public void update(Article article) throws ServiceException {
		try {
			articleValidator.validateUpdate(article);
			int rows=articleDao.update(article);
			logger.log(Level.SEVERE, "Values are updated: %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Update",e);
		}
	}

	public void delete(Article article) throws ServiceException {
		try {
			articleValidator.validateDelete(article);
			int rows=articleDao.delete(article.getId(),article.getUser_id().getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}

}
