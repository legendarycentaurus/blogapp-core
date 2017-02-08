package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nanda.model.User;
import com.nanda.util.ConnectionUtil;


public class UserDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
public int save(User obj) {
	
	String sql = "INSERT INTO USER(NAME,PASSWORD,EMAIL_ID,role_id) VALUES(?,?,?,?) ";
	Object[] params = {obj.getName(),obj.getPassword(),obj.getEmailId(),obj.getRoleId().getId() };
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
public Integer login(User user){
	String sql="SELECT is_present(?,?)";
	Object[] params={ user.getName(),user.getPassword()};
	return jdbcTemplate.queryForObject(sql,params, Integer.class);
}

	public List<User> list() {
		final String sql = "Select id, Name,Password,Email_id from User";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
		 User obj=new User();
		 obj.setId(rs.getInt("id"));
		 obj.setName(rs.getString("Name"));
		 obj.setPassword(rs.getString("Password"));
		 obj.setEmailId(rs.getString("Email_id"));
			return obj;
		});
			}
	
	public List<User> listParticularUser(int id) {
		final String sql = "Select id,Name,Password,Email_id from User where id=?";
		Object[] params={id};
		return jdbcTemplate.query(sql, params,(rs, rowNum) -> {
		 User obj=new User();
		 obj.setId(rs.getInt("id"));
		 obj.setName(rs.getString("Name"));
		 obj.setPassword(rs.getString("Password"));
		 obj.setEmailId(rs.getString("Email_id"));
			return obj;
		});
			}	
	
	

}