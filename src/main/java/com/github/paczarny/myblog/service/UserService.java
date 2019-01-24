package com.github.paczarny.myblog.service;

import com.github.paczarny.myblog.model.Role;
import com.github.paczarny.myblog.model.User;
import com.github.paczarny.myblog.repository.RoleRepository;
import com.github.paczarny.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUserWithDefultRole(User user){
        Role role = roleRepository.findByRole("USER");
        if(role==null) {
            role = new Role("USER");
            roleRepository.save(role);
        }
        user.addRole(role);
        String hashPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPass);
        userRepository.save(user);
    }


}