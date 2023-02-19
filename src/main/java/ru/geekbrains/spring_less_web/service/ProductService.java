package ru.geekbrains.spring_less_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.model.Product;
import ru.geekbrains.spring_less_web.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
//    private List<Optional<Product>> basckets = new ArrayList();
    @Autowired
    private  ProductRepository repository;


    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }


    public List<Product> findAll() {
        return repository.findAll();
    }




    public void saveProduct(long id, String title, int price) {

        repository.save(new Product(id, title, price));
    }


    public void deleteProduct(long id) {
        repository.deleteById(id);
    }

}
