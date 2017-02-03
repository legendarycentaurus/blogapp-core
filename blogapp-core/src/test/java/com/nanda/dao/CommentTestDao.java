package com.nanda.dao;

import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.Comment;
import com.nanda.model.User;
import com.nanda.service.CommentService;

public class CommentTestDao {
public static void main(String[] args) throws ServiceException {
	CommentService commentServiceObj=new CommentService();
	CommentDao commentDaoObj=new CommentDao();
	Comment commentObj=new Comment();
	Article articleObj=new Article();
	User userObj=new User();
	articleObj.setId(3);
	userObj.setId(9);
	commentObj.setArticleId(articleObj);
	commentObj.setUserId(userObj);
	commentObj.setComments("Comment");
	commentServiceObj.save(commentObj);
	
	commentObj.setId(6);
	commentServiceObj.delete(commentObj);
	
	commentDaoObj.list(4);
}
	
}
