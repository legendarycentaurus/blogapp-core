package com.nanda.dao;

import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.ArticleCategory;
import com.nanda.model.SeedCategory;
import com.nanda.service.ArticleCategoryService;

public class ArticleCategoryTestDao  {
public static void main(String[] args) throws ServiceException{

	ArticleCategoryService articleCategoryServiceObj=new ArticleCategoryService(); 
	ArticleCategory articleCategoryObj=new ArticleCategory();
	Article articleObj=new Article();
	articleObj.setId(1);
	SeedCategory obj=new SeedCategory();
	obj.setId(3);
	articleCategoryObj.setArticleId(articleObj);
	articleCategoryObj.setCategoryId(obj);
	
	
	articleCategoryServiceObj.save(articleCategoryObj);
	
	articleCategoryObj.setId(2);
	articleCategoryServiceObj.delete(articleCategoryObj);
	
	
}
}
