package com.nanda.validator;

import com.nanda.exception.ValidationException;
import com.nanda.model.SeedCategory;
import com.nanda.util.ValidationUtil;

public class SeedCategoryValidator {

	private void validateSeedCategory(SeedCategory seedCategory)throws ValidationException{
		ValidationUtil.isNotValid(seedCategory,"Invalid SeedCategory");
	}
	private void validateId(Integer id)throws ValidationException{
		ValidationUtil.isNotValid(id,"Invalid Id");
	}
	private void validateUserId(Integer userId)throws ValidationException{
		ValidationUtil.isNotValid(userId,"Invalid UserId");
	}
	private void validateName(String name)throws ValidationException{
		ValidationUtil.isNotValid(name,"Invalid Name");
	}
	
	
	public void validateSave(SeedCategory seedCategory) throws ValidationException{
		validateSeedCategory(seedCategory);
		validateUserId(seedCategory.getUserId().getId());
		validateName(seedCategory.getCategory());
		
	}
	
	public void validateUpdate(SeedCategory seedCategory) throws ValidationException{
		validateSeedCategory(seedCategory);
		validateId(seedCategory.getId());
		validateName(seedCategory.getCategory());
	}
	
	public void validateDelete(SeedCategory seedCategory) throws ValidationException{
		validateSeedCategory(seedCategory);
		validateId(seedCategory.getId());
	}
}
