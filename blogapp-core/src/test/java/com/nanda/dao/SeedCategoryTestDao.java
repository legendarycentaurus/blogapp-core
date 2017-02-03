package com.nanda.dao;

import com.nanda.exception.ServiceException;
import com.nanda.model.SeedCategory;
import com.nanda.model.User;
import com.nanda.service.SeedCategoryService;

public class SeedCategoryTestDao {
public static void main(String[] args) throws ServiceException {
	
	SeedCategoryService seedCategoryServiceObj=new SeedCategoryService(); 
	SeedCategoryDao seedCategoryDaoObj=new SeedCategoryDao();
	SeedCategory seedCategoryObj=new SeedCategory();
	User userId=new User();
	userId.setId(9);
	seedCategoryObj.setCategory("chemistry");
	seedCategoryObj.setUserId(userId);
	seedCategoryServiceObj.save(seedCategoryObj);

	seedCategoryObj.setCategory("Java");
	seedCategoryObj.setId(1);
	seedCategoryServiceObj.update(seedCategoryObj);
	
	seedCategoryObj.setId(1);
	seedCategoryServiceObj.delete(seedCategoryObj);

seedCategoryDaoObj.list();
}	
}
