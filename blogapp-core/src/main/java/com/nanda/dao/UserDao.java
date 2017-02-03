package com.nanda.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.nanda.model.User;
import com.nanda.util.ConnectionUtil;

public class UserDao {
JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
public int save(User obj) {
	
	String sql = "INSERT INTO USER(NAME,PASSWORD,EMAIL_ID) VALUES(?,?,?) ";
	Object[] params = {obj.getName(),obj.getPassword(),obj.getEmailId() };
	return  jdbcTemplate.update(sql, params);
	
	
}
public int update(User obj) {
	
	String sql = "UPDATE User set password=? where id=?";
	Object[] params = {obj.getPassword(),obj.getId() };
	return  jdbcTemplate.update(sql, params);
	
}

public int delete(int id) {
	
	String sql = "delete from User where id=?";
	return jdbcTemplate.update(sql, id);
	
}


	
	
	
	
	public void list() {
		final String sql = "Select Name,Password,Email_id from User";
		List<User> userRef =jdbcTemplate.query(sql, (rs, rowNum) -> {
		 User obj=new User();
		 obj.setName(rs.getString("Name"));
		 obj.setPassword(rs.getString("Password"));
		 obj.setEmailId(rs.getString("Email_id"));
			return obj;
		});
		for(User ref:userRef)
			System.out.println(ref.getName()+"  "+ref.getPassword()+"  "+ref.getEmailId());
	}
	public void listParticularUser(int id) {
		final String sql = "Select Name,Password,Email_id from User where id=?";
		Object[] params={id};
		List<User> userRef =jdbcTemplate.query(sql, params,(rs, rowNum) -> {
		 User obj=new User();
		 obj.setName(rs.getString("Name"));
		 obj.setPassword(rs.getString("Password"));
		 obj.setEmailId(rs.getString("Email_id"));
			return obj;
		});
		for(User ref:userRef)
			System.out.println(ref.getName()+"  "+ref.getPassword()+"  "+ref.getEmailId());
	}	
	
	

}