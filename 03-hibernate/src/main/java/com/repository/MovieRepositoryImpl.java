package com.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Movie;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext EntityManager em;
	
	@Override
	public Optional<Movie> findMovieById(Long id){
		try{
			return Optional.of(em.find(Movie.class, id));
		}
		catch(NullPointerException npe){
			return Optional.empty();
		}catch(Exception ex){
			ex.printStackTrace();
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<Movie> findByProducent(Integer producer, String title, Integer year){
		try{
			String sql = "SELECT e FROM Movie e WHERE 1 ";
			if(producer != null){
				sql += " OR e.producer = :producer";
			}
			if(title != null){
				sql += " OR e.title = :title";
			}
			if(year != null){
				sql += " OR e.year = :year";
			}
			
			Query query = em.createQuery(sql);
			if(producer != null){
				query.setParameter("producer", producer);
			}
			if(title != null){
				query.setParameter("title", title);
			}
			if(year != null){
				query.setParameter("year", year);
			}
			return Optional.ofNullable((Movie)query.getSingleResult());
		}catch(Exception ex){
			ex.printStackTrace();
			return Optional.empty();
		}
	}
	
	@Override
	public List<Movie> findAll(){
		try{
			String sql = "SELECT e FROM Movie e";
			Query query = em.createQuery(sql);
			return query.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	@Override
	public List<Movie> findShortMovies(int length){
		try{
			String hql = "SELECT e FROM Movie e WHERE e.length < :xyz";
			Query query = em.createQuery(hql);
			query.setParameter("xyz", length);
			return query.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return Collections.EMPTY_LIST;
		}
		
	}
	
	
	@Override
	public List<Movie> findMovieByTitle(String title){
		try{
			String hql = "SELECT e FROM Movie e WHERE e.title like :title";
			Query query = em.createQuery(hql);
			query.setParameter("title", "%"+title+"%");
			return query.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return Collections.EMPTY_LIST;
		}
		
	}
	
	
	@Override
	public List<Movie> findTop10ShortMoviesByProducerName(int length, String firstName){
		
		try {
			String hql ="SELECT e FROM Movie e WHERE e.length < :xyz "
					+ " AND e.producer.imieINazwisko.imie = :imie";
			Query query= em.createQuery(hql);
			query.setParameter("imie", firstName);
			query.setParameter("xyz", length);
			query.setMaxResults(10);
			query.setFirstResult(1);
		
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
		
	}
	
	@Override
	public List<Movie> findByTitleAndYear(String nazwa, Integer year){
		return findAllWithCriteria(nazwa, year, null);
	}
	
	@Override
	public List<Movie> findAllWithCriteria(String nazwa, Integer year, Integer length){
		try{
			CriteriaBuilder cb = em.getCriteriaBuilder();
			//tworzymy obiekt CriteriaQuery 
			CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
			
			Root<Movie> m  =query.from(Movie.class);
			query.select(m);

			Predicate titlePredicate = cb.like(m.get("title"), "%"+nazwa+"%");
			Predicate yearPredicate = cb.equal(m.get("year"), year);
			Predicate lengthPredicate = cb.equal(m.get("length"), length);
			
			
			List<Predicate> list = new ArrayList<>();
			if(nazwa != null){
			list.add(titlePredicate);
			}
			if(year != null){
				list.add(yearPredicate);
			}
			if(length != null){
				list.add(lengthPredicate);
			}
			//query.where(cb.and(titlePredicate, yearPredicate));
			query.where(cb.or(list.toArray(new Predicate[list.size()])));
			// pobieramy takie obiekty Movie które mają nazwe like '%:nazwa%'
			// i rok z parametru year
			return  em.createQuery( query ).getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	@Override
	public Boolean delete(Movie movie) {
		try{
			em.remove(movie);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Movie add(Movie movie) {
		try{
			em.persist(movie);
			em.clear();
			return movie;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean merge(Movie movie) {
		try{
			em.merge(movie);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editTitle(Long movieId, String title) {
		
		Optional<Movie> movie = findMovieById(movieId);
		if(movie.isPresent()){
			movie.get().setTitle(title);
			// metoda merge nic nie robi jeśli, hiernate wie o encji movie
			// ponieważ nią zarządza i znajduję się w kontekście persistance
			// czyli obiekt i tak zostanie zapisany
			// w momencie wyjścia z tranzakcji, hibernate przenosi tranzakcję do bazy danych
			// sprawdza stan encji i porównuje z tym co miał przy pobraniu
			merge(movie.get());
			return true;
		}
		return false;
	}
	
	
	@Override
	public List<Movie> findByAvgMin(int rate){
		
		try {
			String hql = " SELECT m FROM Movie m LEFT JOIN m.movieRating mr GROUP BY mr.movie HAVING AVG(mr.rate) > :rate";
			Query query = em.createQuery(hql);
			query.setParameter("rate", new Double(rate));
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}
	
	@Override
	public List<Movie> findAllTitleAndAvg(){
		String hql = "SELECT new Movie(m.title, AVG(mr.rate) ) FROM Movie m LEFT JOIN m.movieRating mr GROUP BY mr.movie";
		Query query = em.createQuery(hql);
		return query.getResultList();
		
	}
}
