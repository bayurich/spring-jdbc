package ru.netology.jdbctask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbctask.repository.MyRepositoryNew;

import java.util.List;

@RestController
public class MyControllerNew {

    MyRepositoryNew repository;

    public MyControllerNew(MyRepositoryNew repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product-new")
    public List<String> getProduct(@RequestParam("name") String name) throws Exception {
        System.out.println("start request. name: " + name);

        return repository.getProductName(name);
    }
}
