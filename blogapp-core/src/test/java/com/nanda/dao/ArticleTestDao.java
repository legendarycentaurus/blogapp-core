package com.nanda.dao;

import java.util.List;

import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.SeedCategory;
import com.nanda.model.User;
import com.nanda.service.ArticleService;

public class ArticleTestDao {

	public static void main(String[] args) throws ServiceException {
		ArticleService as = new ArticleService();
		Article articleobj = new Article();
		SeedCategory seed=new SeedCategory();
		
		
		seed.setCategory("cvb");//set seed category
		User userobj = new User();

		userobj.setId(9);//set userid
		articleobj.setUserid(userobj);
		articleobj.setTitle("cvb");
		articleobj.setContent("cvb");
		as.publishArticle(articleobj,seed);


		articleobj.setId(1);
		userobj.setId(1);
		articleobj.setUserid(userobj);
		
		List<Article> list=as.list();
		for(Article x: list)
			System.out.println(x.getTitle()+"    "+x.getContent());
	

		List<Article> listMyArticle=as.list();
		for(Article x: listMyArticle)
			System.out.println(x.getTitle()+"    "+x.getContent());
	
		
		List<Article> listCategoryWise=as.list();
		for(Article x: listCategoryWise)
			System.out.println(x.getTitle()+"    "+x.getContent());
	
	}

}
