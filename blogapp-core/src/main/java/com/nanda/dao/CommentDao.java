package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.Comment;
import com.nanda.util.ConnectionUtil;

public class CommentDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(Comment obj) {
		
		String sql = "INSERT INTO Comments(article_id,User_id,Comments) values(?,?,?)";
		Object[] params = {obj.getArticleId().getId() ,obj.getUserId().getId(),obj.getComments()};
		return jdbcTemplate.update(sql, params);
		
	}
	
	
	public int delete(int id) {
		
		String sql = "delete from Comments where id=?";
		return jdbcTemplate.update(sql, id);
}
	public void list(int id) {
		final String sql = "Select comments from Comments where id=?";
		Object[] params={id};
		List<Comment> commentRef =jdbcTemplate.query(sql,params,(rs, rowNum) -> {
		 Comment obj=new Comment();
		 obj.setComments(rs.getString("Comments"));
			return obj;
		});
		for(Comment ref:commentRef)
			System.out.println(ref.getComments());
	}
}

