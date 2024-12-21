package org.example.onlinebookstore.service;

import java.util.List;
import org.example.onlinebookstore.dto.BookDto;
import org.example.onlinebookstore.dto.CreateBookRequestDto;

public interface BookService {

    BookDto findBookById(Long id);

    BookDto save(CreateBookRequestDto bookDto);

    List<BookDto> findAll();
}
