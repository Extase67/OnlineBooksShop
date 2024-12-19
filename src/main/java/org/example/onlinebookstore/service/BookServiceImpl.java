package org.example.onlinebookstore.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.onlinebookstore.model.Book;
import org.example.onlinebookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book save(final Book product) {
        return bookRepository.save(product);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
