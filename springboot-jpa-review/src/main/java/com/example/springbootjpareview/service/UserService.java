package com.example.springbootjpareview.service;

import com.example.springbootjpareview.domain.User;
import com.example.springbootjpareview.domain.dto.UserDto;
import com.example.springbootjpareview.domain.dto.UserRequest;
import com.example.springbootjpareview.domain.dto.UserResponse;
import com.example.springbootjpareview.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);

        if (optUser.isEmpty()) {
            return new UserResponse(id, "", "해당 id의 유저가 없습니다.");
        }
        else {
            User user = optUser.get();
            return new UserResponse(user.getId(), user.getUsername(), "");
        }

    }

    public UserResponse addUser(UserRequest dto) {
        User user = dto.toEntity();
        Optional<User> selectedUser = userRepository.findByUsername(dto.getUsername());
        if (selectedUser.isEmpty()) {
            User savedUser = userRepository.save(user);
            return new UserResponse(savedUser.getId(), savedUser.getUsername(), "유저 등록이 완료되었습니다.");
        } else {
            return new UserResponse(null, dto.getUsername(), "이 이름은 이미 존재합니다. 다른 이름을 사용해주세요.");
        }

    }
}
