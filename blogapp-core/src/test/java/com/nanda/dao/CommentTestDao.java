package com.nanda.dao;

import java.util.List;

import org.apache.commons.mail.EmailException;

import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.Comment;
import com.nanda.model.User;
import com.nanda.service.CommentService;

public class CommentTestDao {
public static void main(String[] args) throws ServiceException,EmailException {
	CommentService commentServiceObj=new CommentService();
	Comment commentObj=new Comment();
	Article articleObj=new Article();
	User userObj=new User();
	articleObj.setId(3);
	userObj.setId(9);
	commentObj.setArticleId(articleObj);
	commentObj.setUserId(userObj);
	commentObj.setComments("Comment");
	commentServiceObj.save(commentObj);
	
//	commentObj.setId(6);
//	commentServiceObj.delete(commentObj);
//	
//	List<Comment> commentRef=commentServiceObj.list(3);//Article id
//	for(Comment ref:commentRef)
//		System.out.println(ref.getComments());

}
	
}
