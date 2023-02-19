package ru.geekbrains.spring_less_web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_less_web.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("/auth_user")
    public void authUser(@RequestParam Long id, @RequestParam String name, @RequestParam String pas) {
        service.addUser(id, name, pas);

    }


}
