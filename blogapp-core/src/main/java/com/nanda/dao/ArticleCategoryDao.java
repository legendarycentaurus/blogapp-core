package com.nanda.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nanda.model.ArticleCategory;
import com.nanda.util.ConnectionUtil;
@Repository
public class ArticleCategoryDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(ArticleCategory obj) {
		
		String sql = "INSERT INTO Article_Category(Article_id,Category_id) values(?,?)";
		Object[] params = {obj.getArticleId().getId(),obj.getCategoryId().getId()};
		return  jdbcTemplate.update(sql, params);
		
	}
	
	
	public int delete(int id) {
		
		String sql = "delete from  Article_Category  where id=?";
		return  jdbcTemplate.update(sql, id);
		
	
}
}
