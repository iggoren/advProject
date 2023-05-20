package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBook(){
       return bookRepository.findAll();
    }
}
