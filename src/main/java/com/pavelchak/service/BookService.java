package com.pavelchak.service;

import com.pavelchak.Repository.BookRepository;
import com.pavelchak.Repository.PersonRepository;
import com.pavelchak.domain.Book;
import com.pavelchak.domain.Person;
import com.pavelchak.exceptions.ExistsPersonForBookException;
import com.pavelchak.exceptions.NoSuchBookException;
import com.pavelchak.exceptions.NoSuchPersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    public Set<Book> getBooksByPersonId(Long person_id) throws NoSuchPersonException {
//        Person person = personRepository.findOne(person_id);//1.5.9
        Person person = personRepository.findById(person_id).get();//2.0.0.M7
        if (person == null) throw new NoSuchPersonException();
        return person.getBooks();
    }

    public Book getBook(Long book_id) throws NoSuchBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Book book = bookRepository.findById(book_id).get();//2.0.0.M7
        if (book == null) throw new NoSuchBookException();
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book uBook, Long book_id) throws NoSuchBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Book book = bookRepository.findById(book_id).get();//2.0.0.M7
        if (book == null) throw new NoSuchBookException();
        //update
        book.setBookName(uBook.getBookName());
        book.setAuthor(uBook.getAuthor());
        book.setPublisher(uBook.getPublisher());
        book.setImprintYear(uBook.getImprintYear());
        book.setAmount(uBook.getAmount());
    }

    @Transactional
    public void deleteBook(Long book_id) throws NoSuchBookException, ExistsPersonForBookException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Book book = bookRepository.findById(book_id).get();//2.0.0.M7

        if (book == null) throw new NoSuchBookException();
        if (book.getPersons().size() != 0) throw new ExistsPersonForBookException();
        bookRepository.delete(book);
    }

}
