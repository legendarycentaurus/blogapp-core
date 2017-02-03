package com.nanda.validator;

import com.nanda.exception.ValidationException;
import com.nanda.model.Comment;
import com.nanda.util.ValidationUtil;

public class CommentValidator {

	private void validateComment(Comment Comment) throws ValidationException {
		ValidationUtil.isNotValid(Comment,"Invalid User");
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
	
	private void validateComment(String comment)throws ValidationException{
		ValidationUtil.isNotValid(comment,"Invalid Comment");
	}
	
	
	public void validateSave(Comment commentDetail) throws ValidationException{
		validateComment(commentDetail);
		validateArticleId(commentDetail.getArticleId().getId());
		validateUserId(commentDetail.getUserId().getId());
		validateComment(commentDetail.getComments());
	}
	
	
	public void validateDelete(Comment commentDetail) throws ValidationException{
		validateComment(commentDetail);
		validateId(commentDetail.getId());
	}
	
	
}
