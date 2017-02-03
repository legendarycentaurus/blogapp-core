package com.nanda.dao;

import java.time.LocalDateTime;
import java.util.List;

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
		SeedCategory sc=new SeedCategory();
//		
//		
//		userobj.setId(1);
//		articleobj.setUser_id(userobj);
//		articleobj.setTitle("DBMS");
//		articleobj.setContent("ACID");
//		articleobj.setCategoryId(sc);
//		as.save(articleobj);
//		
//				articleobj.setTitle("DBMS");
//		articleobj.setContent("ACD");
//		articleobj.setId(3);
//		articleobj.setModified_Date(LocalDateTime.now());
//		as.update(articleobj);
//		
//		
//		
//		articleobj.setId(3);
//		userobj.setId(1);
//		articleobj.setUser_id(userobj);
//		as.delete(articleobj);
//		List<Article> ref=as.list();
//		for(Article a:ref)
//		System.out.println(a.getTitle()+"  "+a.getContent());
		
		
//		List<Article> reference=as.listMyArticle(14);
//		for(Article a:reference)
//			System.out.println(a.getTitle()+"  "+a.getContent());
//			
//		List<Article> references=as.listCategorywise(4);
//		for(Article a:references)
//			System.out.println(a.getTitle()+"  "+a.getContent());
		
		articleobj.setId(1);
		userobj.setId(1);
		articleobj.setUser_id(userobj);
		sc.setId(1);
		articleobj.setCategoryId(sc);
		System.out.println(as.updateCategory(articleobj));
		
	}

}
