package com.nanda.validator;

import java.time.LocalDateTime;

import com.nanda.exception.ValidationException;
import com.nanda.model.Article;
import com.nanda.util.ValidationUtil;

public class ArticleValidator {

	private void validateArticle(Article article) throws ValidationException {
		ValidationUtil.isNotValid(article,"Invalid User");
	}
	
	private void validateId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid Id");
	}
	
	private void validateUserId(Integer userId)throws ValidationException{
		ValidationUtil.isNotValid(userId,"Invalid UserId");
	}
	
	private void validateCategory(Integer userId)throws ValidationException{
		ValidationUtil.isNotValid(userId,"Invalid Category");
	}
	
	private void validateTitle(String name)throws ValidationException{
		ValidationUtil.isNotValid(name,"Invalid Name");
	}
	
	private void validateContent(String content)throws ValidationException{
		ValidationUtil.isNotValid(content,"Invalid Content");
	}
		
	private void validateModifiedDate(LocalDateTime modifiedDate)throws ValidationException{
		ValidationUtil.isNotValid(modifiedDate,"Invalid PublishedDate");
	}

	
	public void validateSave(Article article) throws ValidationException{
		validateArticle(article);
		validateUserId(article.getUser_id().getId());
		validateTitle(article.getTitle());
		validateContent(article.getContent());
		validateCategory(article.getCategoryId().getId());
	}
	
	public void validateUpdate(Article article) throws ValidationException{
		validateArticle(article);
		validateId(article.getId());
		validateModifiedDate(article.getModified_Date());
		validateContent(article.getContent());
	}
	
	public void validateDelete(Article article) throws ValidationException{
		validateArticle(article);
		validateId(article.getId());
	}
	
}
