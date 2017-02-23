package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nanda.model.Article;
import com.nanda.model.Rating;
import com.nanda.model.User;
import com.nanda.util.ConnectionUtil;
@Repository
public class RatingDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(Rating obj) {
		
		String sql = "INSERT INTO Ratings(article_id,User_id,Rating) values(?,?,?)";
		Object[] params = {obj.getArticleId().getId() ,obj.getUserId().getId(),obj.getRating()};
		return jdbcTemplate.update(sql, params);
		
	}
	
public int update(Rating obj) {
		
		String sql = "update Ratings set rating=?  where id=?";
		Object[] params = {obj.getRating(),obj.getId()};
		return jdbcTemplate.update(sql, params);
		
	}
	
	public int delete(int id) {
		
		String sql = "delete from Ratings where id=?";
		return jdbcTemplate.update(sql, id);
		
	
}
	public List<Rating> list(int userId) {
		final String sql = "Select id,rating,Article_id,User_id from ratings where user_id=?";
		Object[] params={userId};
		return jdbcTemplate.query(sql,params,(rs, rowNum) -> {
		 Rating obj=new Rating();
		 Article articleObj=new Article();
		 articleObj.setId((rs.getInt("Article_id")));
		 obj.setArticleId(articleObj);
		 User userObj=new User();
		 userObj.setId(rs.getInt("user_id"));
		 obj.setUserId(userObj);
		 obj.setRating((rs.getInt("Rating")));
		 obj.setId(rs.getInt("id"));
			return obj;
		});
		
		
	
	}
}


