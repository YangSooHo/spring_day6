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
	
	public int addComment(Comment comment) {
		String stmt = COMMENT_NS + "addComment";
		return session.insert(stmt, comment);
	}
}
