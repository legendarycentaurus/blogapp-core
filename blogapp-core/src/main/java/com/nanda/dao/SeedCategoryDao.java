package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.Article;
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

	public List<SeedCategory> list() {
		final String sql = "Select category,userid from SeedCategory";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
		 SeedCategory obj=new SeedCategory();
		 obj.setCategory(rs.getString("Category"));
		 User userObj=new User();
		 userObj.setId(rs.getInt("Userid"));
		 obj.setUserId(userObj);
			return obj;
		});
		}
	
//	public void saveArticleCategory(SeedCategory sc,Article a ){
//		String sql="INSERT INTO ARTICLE(USER_ID,TITLE,CONTENT) VALUES(?,?,?);";
//		Object[] params={ a.getUser_id().getId(),a.getTitle(),a.getContent() };
//		 jdbcTemplate.update(sql, params);
//		 sql="select give_category_id(?,?)";
//		Object[] param={a.getTitle(),a.getUser_id().getId()};
//		Integer articleId=jdbcTemplate.queryForObject(sql,param,Integer.class);
//		if(articleId!=0){
//			sql="insert into Article_category(article_id,Category_id) values(?,?) ";
//		Object[] args={articleId,sc.getId()};
//		jdbcTemplate.update(sql,args);
//		}
//		else{
//		System.out.println("Invalid Category");
//		}
//			
//	}
	
}