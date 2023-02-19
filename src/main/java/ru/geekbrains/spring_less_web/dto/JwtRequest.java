package ru.geekbrains.spring_less_web.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;


}
