package com.nanda.dao;

import com.nanda.model.Article;
import com.nanda.model.Rating;
import com.nanda.model.User;

public class RatingTestDao {

	public static void main(String[] args) {
		
		RatingDao RatingDaoObj=new RatingDao();
		Rating RatingObj=new Rating();
		Article articleObj=new Article();
		User userObj=new User();
		articleObj.setId(3);
		userObj.setId(1);
		RatingObj.setArticleId(articleObj);
		RatingObj.setUserId(userObj);
		RatingObj.setRating(5);
		RatingDaoObj.save(RatingObj);
		
		RatingObj.setRating(3);
		RatingDaoObj.update(RatingObj);
		RatingDaoObj.delete(1);
		
		RatingDaoObj.list(1);
	}
}
