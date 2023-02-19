package ru.geekbrains.spring_less_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.model.Basket;
import ru.geekbrains.spring_less_web.model.Product;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private ProductService service;
    @Autowired
   private Basket basket;

    public void putInBasket(long id) {
       basket.putProductInBasket(id);
    }

    public void deleteInBasket(long id) {
      basket.delProductInBasket(id);
    }

    public List<Product> get(){
        return basket.getBasket();
    }


}
