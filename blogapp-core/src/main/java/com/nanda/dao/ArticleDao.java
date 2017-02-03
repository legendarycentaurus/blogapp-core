package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.Article;
import com.nanda.model.SeedCategory;
import com.nanda.util.ConnectionUtil;

public class ArticleDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(Article articleobj) {

		String sql = "INSERT INTO ARTICLE(USER_ID,TITLE,CONTENT,Article_category) VALUES(?,?,?,?);";
		Object[] params = { articleobj.getUser_id().getId(),articleobj.getTitle(),articleobj.getContent(),articleobj.getCategoryId().getId() };
		return jdbcTemplate.update(sql, params);
		

	}
	public int update(Article articleobj) {

		String sql = "UPDATE ARTICLE SET TITLE=?,CONTENT=?,MODIFIED_DATE=? WHERE ID=?";
		Object[] params = { articleobj.getTitle(), articleobj.getContent(),articleobj.getModified_Date(),articleobj.getId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(int id,int userId) {

		String sql = "delete from Article where id=? and user_id=?";
		Object [] params={id,userId};
		return jdbcTemplate.update(sql,params);

	}
	public void list() {
		final String sql = "Select Title,Content,Article_category from Article";
		List<Article> a =jdbcTemplate.query(sql, (rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
		 SeedCategory seed=new SeedCategory();
		 seed.getId();
		 obj.setCategoryId(seed);
			return obj;
		});
		for(Article ref:a)
			System.out.println(ref.getTitle()+"  "+ref.getContent());
	}
	public void listMyArticle(int id) {
		final String sql = "Select Title,Content from Article where id=?";
		Object[] params={id};
		List<Article> a =jdbcTemplate.query(sql, params,(rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
			return obj;
		});
		for(Article ref:a)
			System.out.println(ref.getTitle()+"  "+ref.getContent());
	}
	
}
