package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.MovieRating;

@Repository
@Transactional
public class MovieRatingRepositoryImpl implements MovieRatingRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void persist(MovieRating movieRating){
		try {
			em.persist(movieRating);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
