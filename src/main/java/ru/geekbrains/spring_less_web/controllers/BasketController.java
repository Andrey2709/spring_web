package ru.geekbrains.spring_less_web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_less_web.model.Product;
import ru.geekbrains.spring_less_web.service.BasketService;
import ru.geekbrains.spring_less_web.service.ProductService;

import java.util.List;

@RestController()
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private ProductService service;
    @Autowired
    private BasketService basketService;



    @GetMapping("/put")
    public List<Product> putInBasket(@RequestParam long id){
        basketService.putInBasket(id);
        return  basketService.get();
    }

    @GetMapping("/delete/inbasket")
    public List<Product> deleteInBasket(@RequestParam long id){
        basketService.deleteInBasket(id);
        return  basketService.get();
    }

    @GetMapping("/all")
    public List<Product> all(){
        return basketService.get();
    }

}
