package com.nanda.validator;

import com.nanda.exception.ValidationException;
import com.nanda.model.Rating;
import com.nanda.util.ValidationUtil;

public class RatingValidator {

	private void validateRating(Rating Rating)throws ValidationException{
		ValidationUtil.isNotValid(Rating,"Invalid category");
	}
	
	private void validateId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid Id");
	}
	
	private void validateArticleId(Integer articleId)throws ValidationException{
		ValidationUtil.isNotValid(articleId,"Invalid ArticleId");
	}
	
	private void validateUserId(Integer userId)throws ValidationException{
		ValidationUtil.isNotValid(userId,"Invalid UserId");
	}
	public void validateUser(Integer userId)throws ValidationException{
		ValidationUtil.isNotValid(userId,"Invalid UserId");
	}
	private void validateRating(Integer rating)throws ValidationException{
		ValidationUtil.isNotValid(rating,"Invalid Comment");
	}
	
	public void validateSave(Rating Rating) throws ValidationException{
		validateRating(Rating);
		validateArticleId(Rating.getArticleId().getId());
		validateUserId(Rating.getUserId().getId());
		validateRating(Rating.getRating());
	}
	
	public void validateUpdate(Rating Rating) throws ValidationException{
		validateRating(Rating);
		validateId(Rating.getId());
		
	}
	
	public void validateDelete(Rating Rating) throws ValidationException{
		validateRating(Rating);
		validateId(Rating.getId());
	}
	
	
}
