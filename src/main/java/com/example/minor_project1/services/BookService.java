package com.example.minor_project1.services;

import com.example.minor_project1.dtos.CreateBookRequest;
import com.example.minor_project1.models.Author;
import com.example.minor_project1.models.Book;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public List<Book> getBooksByStudentId(Integer studentId){
        return this.bookRepository.findByStudentId(studentId);
    }

    public Book getBookById(Integer bookId){
        return this.bookRepository.findById(bookId).orElseThrow(null);


    }

    public Integer create(CreateBookRequest request) {

        Book book = request.mapToBookAndAuthor();
        Author author = book.getAuthor();

        author = this.authorService.getOrCreate(author);
        book.setAuthor(author);
        bookRepository.save(book);
        return book.getId();

        /**
         * Ques - Can FK be null ?
         * Ans - Yes it can be null
         *
         * Ques - Can FK be a wrong value (doesn't exist as a PK in the parent table)?
         * Ans - Not possible
         *
         * Scenario 1
         * author - {id: null, name : '', email: ''}
         *
         * Scenario 2
         * author - null
         */
    }

    public Book createOrUpdate(Book book){
        return this.bookRepository.save(book);
    }


    }
