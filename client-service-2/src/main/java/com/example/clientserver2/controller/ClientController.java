package com.example.clientserver2.controller;

import lombok.AllArgsConstructor;
import com.example.clientserver2.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/client")
public class ClientController {


    @GetMapping("/books")
    List<Book> getAllBooks(){
        return null;
    }

    @GetMapping("/test")
    public String showString(){
        return "test2";
    }
}
