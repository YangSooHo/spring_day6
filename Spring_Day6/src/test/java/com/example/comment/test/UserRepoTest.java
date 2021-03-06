package com.example.comment.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.comment.config.CommentConfig;
import com.example.comment.dto.User;
import com.example.comment.repo.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommentConfig.class})
@Sql({"/dbschema/comment_schema.sql", "/dbschema/comment_data.sql"})
public class UserRepoTest {
	static Logger logger = LoggerFactory.getLogger(UserRepoTest.class);
	
	@Autowired
	UserRepo repo;
	
	@Test
	public void testRepo(){
		assertThat(repo, is(notNullValue()));
	}
	
	@Test
	public void testInsert(){
		User user = new User("yang", "1234");
		int result = repo.addUser(user);
		assertThat(result, is(1));
	}

}
