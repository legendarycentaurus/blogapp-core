package com.nanda.dao;

import java.time.LocalDateTime;

import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.SeedCategory;
import com.nanda.model.User;
import com.nanda.service.ArticleService;

public class ArticleTestDao {

	public static void main(String[] args) throws ServiceException {
		ArticleService as=new ArticleService();
		Article articleobj=new Article();
		ArticleDao articleDaoobj=new ArticleDao();
		User userobj=new User();
		
		userobj.setId(1);
		articleobj.setUser_id(userobj);
		articleobj.setTitle("DBMS");
		articleobj.setContent("ACID");
		SeedCategory sc=new SeedCategory();
		sc.setId(1);
		articleobj.setCategoryId(sc);
		as.save(articleobj);
		
				articleobj.setTitle("DBMS");
		articleobj.setContent("ACD");
		articleobj.setId(3);
		articleobj.setModified_Date(LocalDateTime.now());
		as.update(articleobj);
		
		
		
		articleobj.setId(3);
		userobj.setId(1);
		articleobj.setUser_id(userobj);
		as.delete(articleobj);
		articleDaoobj.list();
		articleDaoobj.listMyArticle(9);
	}

}
