package com.example.springbootjpareview.service;

import com.example.springbootjpareview.domain.User;
import com.example.springbootjpareview.domain.dto.UserFindResponse;
import com.example.springbootjpareview.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserFindResponse getUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.get();
        UserFindResponse userFindResponse = user.of(user);

        return userFindResponse;
    }
}
