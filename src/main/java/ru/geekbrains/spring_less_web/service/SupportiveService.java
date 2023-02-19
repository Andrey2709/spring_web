package ru.geekbrains.spring_less_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.model.User;
import ru.geekbrains.spring_less_web.repository.UserRepository;

import java.util.List;

@Service
public class SupportiveService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUser(){
        return  userRepository.findAll();
    }

}
