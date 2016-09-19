package com.example.comment.test;

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
import com.example.comment.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommentConfig.class})
@Sql({"/dbschema/comment_schema.sql", "/dbschema/comment_data.sql"})
public class UserServiceTest {
	static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	UserService service;

	@Test
	public void test() {
		User user = new User("jang", "1234");
		
		int result = service.join(user);
		
		logger.trace("가입 : {}", result);
	}

}
