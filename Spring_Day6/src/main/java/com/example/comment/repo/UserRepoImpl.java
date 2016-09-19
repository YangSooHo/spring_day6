package com.example.comment.repo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.comment.dto.User;

@Repository
public class UserRepoImpl implements UserRepo{

	@Autowired
	SqlSessionTemplate session;
	
	private final String USER_NS = "com.example.UserRepo.";
	
	public int addUser(User user) {
		String stmt = USER_NS + "addUser";
		return session.insert(stmt, user);
	}
}
