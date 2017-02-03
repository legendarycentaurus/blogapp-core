package com.nanda.dao;

import com.nanda.model.Article;
import com.nanda.model.ArticleCategory;
import com.nanda.model.SeedCategory;

public class ArticleCategoryTestDao {
public static void main(String[] args) {

	
	ArticleCategory articleCategoryObj=new ArticleCategory();
	ArticleCategoryDao articleCategoryDaoObj=new ArticleCategoryDao();
	Article articleObj=new Article();
	articleObj.setId(1);
	SeedCategory obj=new SeedCategory();
	obj.setId(3);
	articleCategoryObj.setArticleId(articleObj);
	articleCategoryObj.setCategoryId(obj);
	articleCategoryDaoObj.save(articleCategoryObj);
	
	articleCategoryDaoObj.delete(1);
	
	
}
}
