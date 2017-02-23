package com.nanda.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nanda.model.Article;
import com.nanda.model.SeedCategory;
import com.nanda.model.User;
import com.nanda.util.ConnectionUtil;
@Repository
public class ArticleDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int save(Article articleobj,SeedCategory seed) {
		if(isAuthor(articleobj)!=0){
		String sql = "INSERT INTO ARTICLE(USER_ID,TITLE,CONTENT) VALUES(?,?,?);";
		Object[] params = { articleobj.getUserid().getId(),articleobj.getTitle(),articleobj.getContent() };
		jdbcTemplate.update(sql, params);
		int articleId=getArticleId(articleobj);
		int categoryId=getCategoryId(articleobj,seed);
		sql="insert into article_category(article_id,category_id) values(?,?)";
		Object[] ac={articleId,categoryId};
		jdbcTemplate.update(sql,ac);
		return categoryId;
		}
		else System.out.println("you are not an author");
		return 0;
	}
	public int isAuthor(Article articleobj){
		String sql="SELECT 1 FROM USER JOIN ROLES ON USER.`ROLE_ID`=ROLES.`ID` AND ROLES.`TYPE`='AUTHOR' WHERE USER.`ID`=?";
		Object[] params={articleobj.getUserid().getId()}; 
		return jdbcTemplate.queryForObject(sql, params,Integer.class);
	}
	public int  getCategoryId(Article articleobj,SeedCategory seed){
		String sql="select fn_get_category_id(?,?)";
		Object[] args={articleobj.getUserid().getId(),seed.getCategory()};
		int categoryId= jdbcTemplate.queryForObject(sql, args,Integer.class);
		if(categoryId==0){
			sql="insert into seedCategory(category,userid) values(?,?); ";
			Object p[]={seed.getCategory(),articleobj.getUserid().getId()};
			jdbcTemplate.update(sql,p);
			}
			
			sql="select fn_get_category_id(?,?)";
			Object[] arg={articleobj.getUserid().getId(),seed.getCategory()};
			return jdbcTemplate.queryForObject(sql, arg,Integer.class);
		
	}
	public int  getArticleId(Article articleobj){
		
		String sql="select fn_get_article_id(?,?)";
		Object[] param={articleobj.getUserid().getId(),articleobj.getTitle()};
		return jdbcTemplate.queryForObject(sql, param,Integer.class);
		
	}
	public int update(Article articleobj) {

		String sql = "UPDATE ARTICLE SET TITLE=?,CONTENT=?,MODIFIED_DATE=? WHERE ID=? and user_id=?";
		Object[] params = { articleobj.getTitle(), articleobj.getContent(),articleobj.getModifiedDate(),articleobj.getId(),articleobj.getUserid().getId() };
		return jdbcTemplate.update(sql, params);

	}
	
	public int delete(int id,int userId) {

		String sql = "delete from Article where id=? and user_id=?";
		Object [] params={id,userId};
		return jdbcTemplate.update(sql,params);

	}
	public List<Article> list() {
		final String sql = "Select Title,Content,user_id from Article";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
		 User userid=new User();
		 userid.setId(rs.getInt("user_id"));
		 obj.setUserid(userid);
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
	
	public List<Article> listByRecent(int id) {
		final String sql = "SELECT Title,Content FROM Article WHERE Created_date BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY)  AND NOW() ORDER BY created_date DESC";
		Object[] params={id};
		return jdbcTemplate.query(sql, params,(rs, rowNum) -> {
		 Article obj=new Article();
		 obj.setTitle(rs.getString("Title"));
		 obj.setContent(rs.getString("Content"));
			return obj;
		});
		
	}
	
}
