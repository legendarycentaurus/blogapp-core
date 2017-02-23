package com.nanda.dao;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nanda.model.Comment;
import com.nanda.util.ConnectionUtil;
import com.nanda.util.MailUtil;
@Repository
public class CommentDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int save(Comment obj) throws EmailException {
		
		String sql = "INSERT INTO Comments(article_id,User_id,Comments) values(?,?,?)";
		Object[] params = {obj.getArticleId().getId() ,obj.getUserId().getId(),obj.getComments()};
		MailUtil.sendSimpleMail(obj.getComments(),"nanda220896@gmail.com","legendarycentaurus");
		return jdbcTemplate.update(sql, params);
		
	}
	
	
	public int delete(int id) {
		
		String sql = "delete from Comments where id=?";
		return jdbcTemplate.update(sql, id);
}
	public List<Comment> list(int id) {
		final String sql = "Select comments from Comments where Article_id=?";
		Object[] params={id};
		return jdbcTemplate.query(sql,params,(rs, rowNum) -> {
		 Comment obj=new Comment();
		 obj.setComments(rs.getString("Comments"));
			return obj;
		});
	
			}
}

