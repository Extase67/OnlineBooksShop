package org.example.onlinebookstore.repository;

import java.util.List;
import java.util.Optional;
import org.example.onlinebookstore.model.Book;

public interface BookRepository {

    Book save(Book book);

    Optional<Book> findBookById(Long id);

    List<Book> findAll();
}
