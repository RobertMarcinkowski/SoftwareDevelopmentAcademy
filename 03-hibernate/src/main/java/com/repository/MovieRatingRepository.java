package com.repository;

import org.springframework.stereotype.Component;

import com.domain.MovieRating;

@Component
public interface MovieRatingRepository {

	void persist(MovieRating movieRating);

}
