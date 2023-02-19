package ru.geekbrains.spring_less_web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_less_web.model.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
