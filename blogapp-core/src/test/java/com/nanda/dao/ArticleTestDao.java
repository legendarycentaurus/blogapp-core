package com.nanda.dao;

import java.time.LocalDateTime;

import com.nanda.model.Article;
import com.nanda.model.User;

public class ArticleTestDao {

	public static void main(String[] args) {
		Article articleobj=new Article();
		ArticleDao articleDaoobj=new ArticleDao();
		User userobj=new User();
		
		userobj.setId(1);
		articleobj.setUser_id(userobj);
		articleobj.setTitle("DBMS");
		articleobj.setContent("ACID");
		articleDaoobj.save(articleobj);
		
		
		articleobj.setTitle("DBMS");
		articleobj.setContent("ACD");
		articleobj.setId(3);
		articleobj.setModified_Date(LocalDateTime.now());
		articleDaoobj.update(articleobj);
		
		articleDaoobj.delete(2,14);
		articleDaoobj.list();
		articleDaoobj.listMyArticle(9);
	}

}
