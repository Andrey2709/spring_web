package ru.geekbrains.spring_less_web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.spring_less_web.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
//    void saveInProduct();
}
