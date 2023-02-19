package ru.geekbrains.spring_less_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.spring_less_web.excemption.ResorseNotFoundExecemption;
import ru.geekbrains.spring_less_web.model.Role;
import ru.geekbrains.spring_less_web.model.User;
import ru.geekbrains.spring_less_web.repository.RoleRepository;
import ru.geekbrains.spring_less_web.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public Optional<User> findByUsername(String username) {
        return userRepository.findByName(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws ResorseNotFoundExecemption {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Неверный логин или пароль."));

        System.out.println(user.getName());
        return new org.springframework.security.core.userdetails
                .User(user.getName(), user.getPas(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public void addUser(Long id, String name, String pas) {
        List<Role> r = new ArrayList<>();
        r.add(roleRepository.findById(1l).get());
        User u = new User(id, name, pas, r);
        userRepository.save(u);

    }


}
