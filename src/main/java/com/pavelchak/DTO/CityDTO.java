package com.pavelchak.DTO;

import com.pavelchak.controller.PersonController;
import com.pavelchak.domain.City;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchCityException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CityDTO extends ResourceSupport {
    City city;
    public CityDTO(City city, Link selfLink) throws NoSuchPersonException, NoSuchBookException, NoSuchCityException {
        this.city=city;
        add(selfLink);
        add(linkTo(methodOn(PersonController.class).getPersonsByCityID(city.getId())).withRel("persons"));
    }

    public Long getCityId() { return city.getId(); }

    public String getCity() {
        return city.getCity();
    }
}
