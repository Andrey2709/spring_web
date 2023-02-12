package ru.geekbrains.spring_less_web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/all")
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new ResorseNotFoundExecemption("Продуку по id: " + id + " ненайден"));
    }

    //    @GetMapping("/add/{id}")
//    public  List<Optional<Product>> addProduct(@PathVariable Long id){
//        return service.addProduct(id);
//    }
    @GetMapping("/create")
    public void create(@RequestParam long id, @RequestParam String title, @RequestParam() int price) {

            service.saveProduct(id, title, price);
    }

    @GetMapping("/delet")
    public void delete(@RequestParam long id){
        service.deleteProduct(id);

    }


}
