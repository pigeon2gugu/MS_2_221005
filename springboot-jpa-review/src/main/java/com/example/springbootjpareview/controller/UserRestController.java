package com.example.springbootjpareview.controller;

import com.example.springbootjpareview.domain.dto.UserFindResponse;
import com.example.springbootjpareview.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFindResponse> get(@PathVariable Long id) {
        UserFindResponse userFindResponse = userService.getUser(id);
        return ResponseEntity.ok().body(userFindResponse);
    }
}