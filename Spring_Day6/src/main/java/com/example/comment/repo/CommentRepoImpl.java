package com.example.comment.repo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.comment.dto.Comment;

@Repository
public class CommentRepoImpl implements CommentRepo {
	
	@Autowired
	SqlSessionTemplate session;
	
	private final String COMMENT_NS = "com.example.CommentRepo.";
	
	public int insert(Comment comment) {
		String stmt = COMMENT_NS + "insert";
		return session.insert(stmt, comment);
	}
}
