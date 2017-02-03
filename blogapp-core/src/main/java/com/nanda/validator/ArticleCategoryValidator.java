package com.nanda.validator;

import com.nanda.exception.ValidationException;
import com.nanda.model.ArticleCategory;
import com.nanda.util.ValidationUtil;

public class ArticleCategoryValidator {

	
	private void validateArticleCategory(ArticleCategory ArticleCategory)throws ValidationException{
		ValidationUtil.isNotValid(ArticleCategory,"Invalid category");
	}
	
	private void validateId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid Id");
	}
	
	private void validateArticleId(Integer articleId)throws ValidationException{
		ValidationUtil.isNotValid(articleId,"Invalid ArticleId");
	}
	
	private void validateCategoryId(Integer categoryId)throws ValidationException{
		ValidationUtil.isNotValid(categoryId,"Invalid CategoryId");
	}
	
	
	public void validateSave(ArticleCategory articleCategory) throws ValidationException{
		validateArticleCategory(articleCategory);
		
		validateArticleId(articleCategory.getArticleId().getId());
		validateCategoryId(articleCategory.getCategoryId().getId());
	}
	
	
	public void validateDelete(ArticleCategory ArticleCategory) throws ValidationException{
		validateArticleCategory(ArticleCategory);
		validateId(ArticleCategory.getId());
	}
}
