package com.example.springbootjdbcuserdao.controller;

import com.example.springbootjdbcuserdao.dao.UserDao;
import com.example.springbootjdbcuserdao.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public void add() {
        User user1 = new User("1", "Kyeongrok", "1234");
        userDao.add(user1);
        System.out.println("유저 정보 등록 완료.");
        System.out.printf("id : %s, name : %s, password : %s \n", user1.getId(), user1.getName(), user1.getPassword());
    }

    @DeleteMapping("/user")
    public void delete() {
        userDao.deleteAll();
        System.out.println("유저 정보 전부 삭제.");
    }

    @DeleteMapping("/user")
    public void deleteById() {
        String dId = "1";
        userDao.deleteById(dId);
        System.out.printf("%s 번 유저 정보 삭제.", dId);
    }
}

