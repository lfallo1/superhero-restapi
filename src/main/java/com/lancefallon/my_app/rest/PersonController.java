package com.lancefallon.my_app.rest;

import com.lancefallon.my_app.model.PersonDTO;
import com.lancefallon.my_app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable final Long id) {
        return personService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createPerson(@RequestBody @Valid final PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable final Long id, @RequestBody @Valid final PersonDTO personDTO) {
        personService.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable final Long id) {
        personService.delete(id);
    }

}
