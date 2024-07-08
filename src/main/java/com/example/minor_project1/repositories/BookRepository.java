package com.example.minor_project1.repositories;

import com.example.minor_project1.models.Book;
import com.example.minor_project1.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    //    @Query()
    List<Book> findByStudentId(int studentId);
}