package com.nanda.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nanda.config.AppConfig;
import com.nanda.exception.ServiceException;
import com.nanda.model.SeedCategory;
import com.nanda.model.User;
import com.nanda.service.SeedCategoryService;

public class SeedCategoryTestDao {
	public static void main(String[] args) throws ServiceException {

		// = new SeedCategoryService();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SeedCategoryService seedCategoryServiceObj  = ctx.getBean(SeedCategoryService.class);
		SeedCategory seedCategoryObj = new SeedCategory();
		User userId = new User();
		userId.setId(9);
		seedCategoryObj.setCategory("chemistry");
		seedCategoryObj.setUserId(userId);
		seedCategoryServiceObj.save(seedCategoryObj);

		seedCategoryObj.setCategory("Java");
		seedCategoryObj.setId(1);
		seedCategoryServiceObj.update(seedCategoryObj);

		seedCategoryObj.setId(1);
		seedCategoryServiceObj.delete(seedCategoryObj);

		List<SeedCategory> sC = seedCategoryServiceObj.list();
		for (SeedCategory ref : sC)
			System.out.println(ref.getCategory() + "  " + ref.getUserId().getId());
		ctx.close();

			}
}
