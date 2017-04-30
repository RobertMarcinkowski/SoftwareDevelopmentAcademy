package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.MovieComment;

@Transactional
@Repository
public class MovieCommentRepositoryImpl implements MovieCommentRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void persist(MovieComment mv){
		try {
			em.persist(mv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
