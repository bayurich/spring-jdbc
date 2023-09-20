package ru.netology.jdbctask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbctask.repository.MyRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MyController {

    MyRepository repository;

    public MyController(MyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProduct(@RequestParam("name") String name) throws Exception {
        System.out.println("start request. name: " + name);

        return repository.getProductName(name);
    }
}
