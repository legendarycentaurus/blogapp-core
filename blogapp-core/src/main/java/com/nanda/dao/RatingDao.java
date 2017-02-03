package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.Rating;
import com.nanda.util.ConnectionUtil;

public class RatingDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(Rating obj) {
		
		String sql = "INSERT INTO Ratings(article_id,User_id,Rating) values(?,?,?)";
		Object[] params = {obj.getArticleId().getId() ,obj.getUserId().getId(),obj.getRating()};
		return jdbcTemplate.update(sql, params);
		
	}
	
public int update(Rating obj) {
		
		String sql = "update Ratings set rating=?  where Article_id=?";
		Object[] params = {obj.getRating(),obj.getArticleId().getId()};
		return jdbcTemplate.update(sql, params);
		
	}
	
	public int delete(int id) {
		
		String sql = "delete from Ratings where id=?";
		return jdbcTemplate.update(sql, id);
		
	
}
	public void list(int userId) {
		final String sql = "Select rating from ratings where user_id=?";
		Object[] params={userId};
		List<Rating> ratingRef =jdbcTemplate.query(sql,params,(rs, rowNum) -> {
		 Rating obj=new Rating();
		 obj.setRating((rs.getInt("Rating")));
			return obj;
		});
		for(Rating ref:ratingRef)
			System.out.println(ref.getRating());
	}
}


