package ru.geekbrains.spring_less_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "pas")
    private String pas;


    @Column(name = "roles")
    @OneToMany
    private List<Role> roles;



    public User() {
    }
}
