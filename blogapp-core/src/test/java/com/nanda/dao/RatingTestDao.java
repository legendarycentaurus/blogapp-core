package com.nanda.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nanda.config.AppConfig;
import com.nanda.exception.ServiceException;
import com.nanda.model.Article;
import com.nanda.model.Rating;
import com.nanda.model.User;
import com.nanda.service.RatingService;

public class RatingTestDao {

	public static void main(String[] args) throws ServiceException {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		RatingService RatingServiceObj  = ctx.getBean(RatingService.class);//=new RatingService();
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
		
		List<Rating> r=RatingServiceObj.list(89);
		for(Rating ref:r)
			System.out.println(ref.getRating());
		ctx.close();
	}
}
