package ru.geekbrains.spring_less_web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Basket {
    @Autowired
    private ProductService service;
    private List<Product> basket = new ArrayList<>();

    public Basket(List<Product> basket) {
        this.basket = basket;
    }


    public void putProductInBasket(long id) {
        Product product = service.findById(id).get();
        basket.add(product);
    }

    public void delProductInBasket(long id) {
        Product p = basket.stream().filter(product -> product.getId().equals(id)).findFirst().get();
        basket.remove(p);
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }
}
