package com.repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Movie;
import com.domain.Producer;

@Repository
@Transactional
public class ProducerRepositoryImpl implements ProducerRepository {

	@PersistenceContext
	EntityManager em;
	
	 
	@Override
	public List<Producer> findAllByNazwaStudia(String nazwaStudia){
		try{
		String hql = "SELECT p FROM Producer p LEFT JOIN FETCH p.movies "
				+ " WHERE p.nazwaStudia = :nazwaStudia OR p.imieINazwisko.nazwisko = :nazwisko";
		Query query = em.createQuery(hql);
		query.setParameter("nazwaStudia", nazwaStudia);
		query.setParameter("nazwisko", "Kowalski");

		List<Producer> list=  query.getResultList();
		
		return list;
		}catch (Exception ex) {
			return Collections.emptyList();
		}
	}
	
	@Override
	public Optional<Producer> findByFirstNameAndLastName(String firstName, String lastName){
		try{
		String hql  = "SELECT e FROM Producer e WHERE UPPER(e.imieINazwisko.imie) like :imie "
				+ "AND UPPER(e.imieINazwisko.nazwisko) like :nazwisko";
		
		Query query = em.createQuery(hql);
		query.setParameter("imie", firstName.toUpperCase());
		query.setParameter("nazwisko", lastName.toUpperCase());
		
		return Optional.ofNullable((Producer)query.getSingleResult());
		}catch(NoResultException nre){
			return Optional.empty();
		}catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
	
	
	
	
	@Override
	public Producer merge(Producer producer){
		try{
			Producer p = em.merge(producer);
			em.clear();
			//p.setNazwaStudia("aaa");
			return p;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void persist(Producer producer){
		try{
		em.persist(producer);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}
		
	
	@Override
	public Optional<Producer> findProducer(Long id){
		try{
		return Optional.of(em.find(Producer.class, id));
		}catch(NullPointerException npe){
			return Optional.empty();
		}catch(Exception ex){
			ex.printStackTrace();
			return Optional.empty();
		}
	}
	
	
	
}
