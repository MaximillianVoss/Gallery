package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.User;
import com.goganesh.gallery.model.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
