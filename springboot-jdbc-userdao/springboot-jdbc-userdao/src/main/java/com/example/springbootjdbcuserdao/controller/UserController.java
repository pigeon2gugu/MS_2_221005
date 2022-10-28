package com.example.springbootjdbcuserdao.controller;

import com.example.springbootjdbcuserdao.dao.UserDao;
import com.example.springbootjdbcuserdao.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user")
    public String add() throws SQLException {
        User user1 = new User("1", "Haneul", "1234");
        userDao.add(user1);
        return user1.getName();
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(userDao.deleteById(id));
    }
}

