package com.example.bookservice.controller;

import com.example.bookservice.entity.Book;
import com.example.bookservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }
}
