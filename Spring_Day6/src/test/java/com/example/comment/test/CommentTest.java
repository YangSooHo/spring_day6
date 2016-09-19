package com.example.comment.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.comment.config.CommentConfig;
import com.example.comment.repo.CommentRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommentConfig.class})
public class CommentTest {
	static Logger logger = LoggerFactory.getLogger(CommentTest.class);
	
	@Autowired
	CommentRepo repo;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionTemplate template;
	
	@Test
	public void testRepo() {
		logger.trace("repo : {}", repo);
		assertThat(repo, is(notNullValue()));
	}
	
	@Test
	public void testDs() throws SQLException{
		logger.trace("DataSource : {}", ds);
		assertThat(ds, is(notNullValue()));
	}
	
	@Test
	public void testSession(){
		logger.trace("Session : {}",template);
	}
	
	/*@Test
	public void testInsert(){
		Comment comment = new Comment(0, "hong", "test");
		logger.trace("comment no. : {}", comment.getCommentNo());
		int result = repo.insert(comment);
		logger.trace("comment no. : {}", comment.getCommentNo());
		assertThat(result, is(1));
	}*/


}
