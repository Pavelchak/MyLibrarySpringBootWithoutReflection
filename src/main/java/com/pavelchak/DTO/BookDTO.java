package com.pavelchak.DTO;

import com.pavelchak.controller.PersonController;
import com.pavelchak.domain.Book;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class BookDTO extends ResourceSupport {
    Book book;
    public BookDTO(Book book, Link selfLink) throws NoSuchBookException, NoSuchPersonException {
        this.book=book;
        add(selfLink);

        add(linkTo(methodOn(PersonController.class).getPersonsByBookID(book.getId())).withRel("persons"));
    }

    public Long getBookId() {
        return book.getId();
    }

    public String getBookName() {
        return book.getBookName();
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public String getPublisher() {
        return book.getPublisher();
    }

    public Integer getImprintYear() {
        return book.getImprintYear();
    }

    public Integer getAmount() {
        return book.getAmount();
    }

}
