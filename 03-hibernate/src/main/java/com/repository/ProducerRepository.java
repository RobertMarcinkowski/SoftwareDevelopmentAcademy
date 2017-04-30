package com.repository;

import java.util.List;
import java.util.Optional;

import com.domain.Producer;

public interface ProducerRepository {

	List<Producer> findAllByNazwaStudia(String nazwaStudia);

	void persist(Producer producer);

	Producer merge(Producer producer);

	Optional<Producer> findProducer(Long id);

	Optional<Producer> findByFirstNameAndLastName(String firstName, String lastName);

}
