package com.lancefallon.my_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lancefallon.my_app.domain.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
    // add custom queries here
}
