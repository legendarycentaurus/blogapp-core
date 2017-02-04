package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.Article;
import com.nanda.util.ConnectionUtil;

public class ArticleDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(Article articleobj) {

		String sql = "INSERT INTO ARTICLE(USER_ID,TITLE,CONTENT) VALUES(?,?,?);";
		Object[] params = { articleobj.getUser_id().getId(),articleobj.getTitle(),articleobj.getContent() };
		return jdbcTemplate.update(sql, params);
		

	}
	public int update(Article articleobj) {

		String sql = "UPDATE ARTICLE SET TITLE=?,CONTENT=?,MODIFIED_DATE=? WHERE ID=? and user_id=?";
		Object[] params = { articleobj.getTitle(), articleobj.getContent(),articleobj.getModified_Date(),articleobj.getId(),articleobj.getUser_id().getId() };
		return jdbcTemplate.update(sql, params);

	}
	
	public int delete(int id,int userId) {

		String sql = "delete from Article where id=? and user_id=?";
		Object [] params={id,userId};
		return jdbcTemplate.update(sql,params);

	}
	public List<Article> list() {
		final String sql = "Select Title,Content,Article_category from Article";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
		return obj;
		});
		

	}
	public List<Article> listMyArticle(int id) {
		final String sql = "Select Title,Content from Article where user_id=?";
		Object[] params={id};
		return jdbcTemplate.query(sql, params,(rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
			return obj;
		});
		
	}
	
	public List<Article> listCatgorywise(int id) {
		final String sql = "Select Title,Content from Article where article_category=?";
		Object[] params={id};
		return jdbcTemplate.query(sql, params,(rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
			return obj;
		});
		
	}
	
}
