package com.lancefallon.my_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.lancefallon.my_app.config.CustomNotFoundException;
import com.lancefallon.my_app.domain.Person;
import com.lancefallon.my_app.model.PersonDTO;
import com.lancefallon.my_app.repos.PersonRepository;


@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> mapToDTO(person, new PersonDTO()))
                .collect(Collectors.toList());
    }

    public PersonDTO get(final Long id) {
        return personRepository.findById(id)
                .map(person -> mapToDTO(person, new PersonDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public Long create(final PersonDTO personDTO) {
        final Person person = new Person();
        mapToEntity(personDTO, person);
        return personRepository.save(person).getId();
    }

    public void update(final Long id, final PersonDTO personDTO) {
        final Person person = personRepository.findById(id)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(personDTO, person);
        personRepository.save(person);
    }

    public void delete(final Long id) {
        personRepository.deleteById(id);
    }

    private PersonDTO mapToDTO(final Person person, final PersonDTO personDTO) {
        personDTO.setId(person.getId());
        personDTO.setAlias(person.getAlias());
        personDTO.setFirstname(person.getFirstname());
        personDTO.setLastname(person.getLastname());
        personDTO.setPower(person.getPower());
        personDTO.setType(person.getType());
        return personDTO;
    }

    private Person mapToEntity(final PersonDTO personDTO, final Person person) {
        person.setAlias(personDTO.getAlias());
        person.setFirstname(personDTO.getFirstname());
        person.setLastname(personDTO.getLastname());
        person.setPower(personDTO.getPower());
        person.setType(personDTO.getType());
        return person;
    }

}
