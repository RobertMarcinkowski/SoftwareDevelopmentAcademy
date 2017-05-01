package com.example.repository;

import com.example.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RENT on 2017-02-28.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByName(String name);

    List<Person> findByNameOrderByName(String name);

    List<Person> findBySurnameOrderByName(String surname);

    List<Person> findByNameAndSurnameOrderByName(String name, String surname);

    List<Person> findByNameAndSurname(String name, String surname);

    List<Person> findByNameAndSurnameOrderBySurname(String name, String surname);

    List<Person> findAllByOrderByName();

    List<Person> findAllByOrderBySurname();

    List<Person> findByNameOrderBySurname(String name);

    List<Person> findBySurnameOrderBySurname(String surname);

    List<Person> findByNameOrderBySurnameAsc(String name);

    List<Person> findByNameLike(String name);
    
    List<Person> findByNameIgnoreCaseContaining(String name);

}
