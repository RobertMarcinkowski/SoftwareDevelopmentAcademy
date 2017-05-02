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

    //1
    List<Person> findByNameLikeOrderByName(String name);

    //2
    List<Person> findBySurnameLikeOrderByName(String surname);

    //3
    Iterable<Person> findByNameIgnoreCaseContainingAndSurnameIgnoreCaseContainingOrderByName(String name, String surname);

    //4
    List<Person> findByNameLikeOrderBySurname(String name);

    //5
    List<Person> findBySurnameLikeOrderBySurname(String surname);

    //6
    Iterable<Person> findByNameIgnoreCaseContainingAndSurnameIgnoreCaseContainingOrderBySurname(String name, String surname);

    //7
    List<Person> findAllByOrderByName();

    //8
    List<Person> findAllByOrderBySurname();

    List<Person> findByNameAndSurname(String name, String surname);

    List<Person> findByNameOrderBySurnameAsc(String name);

    List<Person> findByNameIgnoreCaseContaining(String name);

}
