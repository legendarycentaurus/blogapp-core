package com.nanda.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.nanda.dao.ArticleCategoryDao;
import com.nanda.exception.ServiceException;
import com.nanda.exception.ValidationException;
import com.nanda.model.ArticleCategory;
import com.nanda.validator.ArticleCategoryValidator;

public class ArticleCategoryService {

	private ArticleCategoryValidator articleCategoryValidator = new ArticleCategoryValidator();
	private ArticleCategoryDao articleCategoryDao=new ArticleCategoryDao();
	private final Logger logger = Logger.getLogger(ArticleService.class.getName());

	public void save(ArticleCategory articleCategory) throws ServiceException {
		try {
			articleCategoryValidator.validateSave(articleCategory);
			int rows=articleCategoryDao.save(articleCategory);
			logger.log(Level.SEVERE, "You have been Signedup: %d ", rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Register",e);
		}
	}

	

	public void delete(ArticleCategory articleCategory) throws ServiceException {
		try {
			articleCategoryValidator.validateDelete(articleCategory);
			int rows=articleCategoryDao.delete(articleCategory.getId());
			logger.log(Level.SEVERE, "Deleted %d",rows);
		} catch (ValidationException e) {
			throw new ServiceException("Unable to Delete",e);
		}
	}

	
	
	
}
