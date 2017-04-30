package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.domain.Movie;

@Component
public interface MovieRepository {

	List<Movie> findAll();

	Boolean delete(Movie movie);

	Movie add(Movie movie);

	Boolean merge(Movie movie);

	List<Movie> findAllWithCriteria(String nazwa, Integer year, Integer length);

	Optional<Movie> findMovieById(Long id);

	Boolean editTitle(Long movieId, String title);

	List<Movie> findShortMovies(int length);

	List<Movie> findTop10ShortMoviesByProducerName(int length, String firstName);
	List<Movie> findMovieByTitle(String title);

	Optional<Movie> findByProducent(Integer producer, String title, Integer year);

	List<Movie> findByTitleAndYear(String nazwa, Integer year);

	List<Movie> findByAvgMin(int avg);

	List<Movie> findAllTitleAndAvg();

	
}
