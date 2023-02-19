package ru.geekbrains.spring_less_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String pas;



    @ManyToMany
    @JoinTable(name="users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))

    private List<Role> roles;



    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(Long id, String name, String pas, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.pas = pas;
        this.roles = roles;
    }
}
