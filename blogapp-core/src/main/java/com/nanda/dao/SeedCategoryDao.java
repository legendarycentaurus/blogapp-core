package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.SeedCategory;
import com.nanda.model.User;
import com.nanda.util.ConnectionUtil;

public class SeedCategoryDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(SeedCategory obj) {
		
		String sql = "INSERT INTO SeedCategory(Category,userID) values(?,?)  ";
		Object[] params = {obj.getCategory(),obj.getUserId().getId() };
		return  jdbcTemplate.update(sql, params);
		
	}
	public int update(SeedCategory obj) {
		
		String sql = "UPDATE SeedCategory set Category=? where id=?";
		Object[] params = { obj.getCategory(),obj.getId()};
		return jdbcTemplate.update(sql, params);
		
	}
	
	public int delete(int id) {
		
		String sql = "delete from SeedCategory where id=?";
		return  jdbcTemplate.update(sql, id);
}

	public void list() {
		final String sql = "Select category,userid from SeedCategory";
		List<SeedCategory> a =jdbcTemplate.query(sql, (rs, rowNum) -> {
		 SeedCategory obj=new SeedCategory();
		 obj.setCategory(rs.getString("Category"));
		 User userObj=new User();
		 userObj.setId(rs.getInt("Userid"));
		 obj.setUserId(userObj);
			return obj;
		});
		for(SeedCategory ref:a)
			System.out.println(ref.getCategory()+"  "+ref.getUserId().getId());
	}
	
	
	
}