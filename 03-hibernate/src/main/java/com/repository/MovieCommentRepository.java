package com.repository;

import org.springframework.stereotype.Component;

import com.domain.MovieComment;

@Component
public interface MovieCommentRepository {

	void persist(MovieComment mv);

}
