package com.example.springbootjpareview.controller;

import com.example.springbootjpareview.domain.dto.UserRequest;
import com.example.springbootjpareview.domain.dto.UserResponse;
import com.example.springbootjpareview.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Long id) {
        UserResponse userFindResponse = userService.getUser(id);
        return ResponseEntity.ok().body(userFindResponse);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> add(@RequestBody UserRequest dto) {
        UserResponse userResponse = userService.addUser(dto);
        return ResponseEntity.ok().body(userResponse);
    }
}
