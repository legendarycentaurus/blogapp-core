package com.nanda.dao;

import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.Rating;
import com.nanda.model.User;
import com.nanda.service.RatingService;

public class RatingTestDao {

	public static void main(String[] args) throws ServiceException {
		RatingService RatingServiceObj=new RatingService();
		RatingDao RatingDaoObj=new RatingDao();
		Rating RatingObj=new Rating();
		Article articleObj=new Article();
		User userObj=new User();
		articleObj.setId(3);
		userObj.setId(1);
		RatingObj.setArticleId(articleObj);
		RatingObj.setUserId(userObj);
		RatingObj.setRating(5);
		RatingServiceObj.save(RatingObj);
		
		RatingObj.setRating(3);
		RatingServiceObj.update(RatingObj);
		
		RatingObj.setId(5);
		RatingServiceObj.delete(RatingObj);
		
		RatingDaoObj.list(1);
	}
}
