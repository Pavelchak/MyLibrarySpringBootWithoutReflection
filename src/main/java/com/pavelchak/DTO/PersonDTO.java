package com.pavelchak.DTO;

import com.pavelchak.controller.BookController;
import com.pavelchak.domain.Person;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PersonDTO extends ResourceSupport {
    Person person;
    public PersonDTO(Person person, Link selfLink) throws NoSuchPersonException, NoSuchBookException {
        this.person=person;
        add(selfLink);
        add(linkTo(methodOn(BookController.class).getBooksByPersonID(person.getId())).withRel("books"));
    }

    public Long getPersonId() {
        return person.getId();
    }

    public String getSurname() {
        return person.getSurname();
    }

    public String getName() {
        return person.getName();
    }

    public String getEmail() {
        return person.getEmail();
    }

    public String getCity() {
        if(person.getCity()==null) return "";
        return person.getCity().getCity();
    }

    public String getStreet() {
        return person.getStreet();
    }

    public String getApartment() {
        return person.getApartment();
    }
}
