package com.matheuscordeiro.javarecords.controller;

import com.matheuscordeiro.javarecords.domain.Person;
import com.matheuscordeiro.javarecords.dto.PersonRecordDto;
import com.matheuscordeiro.javarecords.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    ResponseEntity<List<PersonRecordDto>> list() {
        final var list = personRepository.findAll();
        final var dtoList = list.stream().map(p -> new PersonRecordDto(p.getName(), p.getAge())).toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    ResponseEntity<PersonRecordDto> getById(@PathVariable Long id) {
        final var person = personRepository.findById(id).orElseThrow();
        final var dto = new PersonRecordDto(person.getName(), person.getAge());
        dto.printName();
        PersonRecordDto.printMessage();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("name/{id}")
    ResponseEntity<String> getName(@PathVariable Long id) {
        final var person = personRepository.findById(id).orElseThrow();
        final var dto = new PersonRecordDto(person.getName(), person.getAge());
        dto.printName();
        PersonRecordDto.printMessage();
        return ResponseEntity.ok(dto.name());
    }

    @PostMapping
    ResponseEntity<PersonRecordDto> save(@RequestBody @Valid PersonRecordDto personRecordDto) {
        final var person = new Person();
        person.setName(personRecordDto.name());
        person.setAge(personRecordDto.age());
        final var personSaved = personRepository.save(person);
        final var dto = new PersonRecordDto(personSaved.getName(), personSaved.getAge());
        dto.printName();
        PersonRecordDto.printMessage();
        return ResponseEntity.ok(dto);
    }
}
