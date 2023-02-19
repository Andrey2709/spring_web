package ru.geekbrains.spring_less_web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_less_web.excemption.ExcemptHendler;
import ru.geekbrains.spring_less_web.excemption.ResorseNotFoundExecemption;
import ru.geekbrains.spring_less_web.model.Product;
import ru.geekbrains.spring_less_web.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/auth/all")
    @PreAuthorize("USER")
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping(value = "/auth/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new ResorseNotFoundExecemption("Продукт с id: " +id+" не найден"));
    }




}
