package ru.geekbrains.spring_less_web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_less_web.model.User;
import ru.geekbrains.spring_less_web.service.ProductService;
import ru.geekbrains.spring_less_web.service.SupportiveService;

import java.util.List;

@RestController()
@RequestMapping("/admin")
public class SupportiveController {
    @Autowired
    private ProductService service;
    @Autowired
    SupportiveService supportiveService;

    @GetMapping("/all_user")

    private List<User> getAllUser() {
        return supportiveService.getAllUser();
    }
    @PostMapping("/create_product")

    public void create(@RequestParam long id, @RequestParam String title, @RequestParam() int price) {
        service.saveProduct(id, title, price);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam long id){
        service.deleteProduct(id);

    }
}
