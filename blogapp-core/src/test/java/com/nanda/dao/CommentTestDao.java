package com.nanda.dao;

import com.nanda.model.Article;
import com.nanda.model.Comment;
import com.nanda.model.User;

public class CommentTestDao {
public static void main(String[] args) {
	
	CommentDao commentDaoObj=new CommentDao();
	Comment commentObj=new Comment();
	Article articleObj=new Article();
	User userObj=new User();
	articleObj.setId(3);
	userObj.setId(9);
	commentObj.setArticleId(articleObj);
	commentObj.setUserId(userObj);
	commentObj.setComments("Comment");
	commentDaoObj.save(commentObj);
	
	commentDaoObj.delete(2);
	
	commentDaoObj.list(4);
}
	
}
