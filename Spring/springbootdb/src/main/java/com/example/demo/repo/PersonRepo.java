package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Person;

public interface PersonRepo extends CrudRepository<Person,Integer> {

}
