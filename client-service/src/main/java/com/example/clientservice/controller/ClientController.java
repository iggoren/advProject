package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/books")
    List<Book> getAllBooksFromClient() {
        return clientService.getAllBooks();
    }

    @GetMapping("/test")
    public String showString() {
        return "test1";
    }
}
