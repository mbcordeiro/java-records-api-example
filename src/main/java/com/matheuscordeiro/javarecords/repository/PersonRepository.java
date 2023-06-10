package com.matheuscordeiro.javarecords.repository;

import com.matheuscordeiro.javarecords.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
