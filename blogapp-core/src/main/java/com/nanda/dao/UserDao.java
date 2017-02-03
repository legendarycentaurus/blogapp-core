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
public String login(User user){
	String result;
	String sql="SELECT IFNULL((SELECT 1 FROM USER WHERE NAME=? AND PASSWORD=?),NULL);";
	Object[] params={ user.getName(),user.getPassword()};
	Integer value=jdbcTemplate.queryForObject(sql,params, Integer.class);
	if(value!=null){
		result="Successful Login";
	}
	else {
		result="Invalid Username or Password";
		}
	return result;
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