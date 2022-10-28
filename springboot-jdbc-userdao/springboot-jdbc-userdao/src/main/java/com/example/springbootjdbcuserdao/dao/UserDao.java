package com.example.springbootjdbcuserdao.dao;

import com.example.springbootjdbcuserdao.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        this.jdbcTemplate.update("INSERT INTO users(id, name, password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword());
        System.out.println("add ok");
    }

    public int deleteAll() {
        return this.jdbcTemplate.update("DELETE FROM users");
    }

    public int deleteById(String id) {
        return this.jdbcTemplate.update("DELETE FROM users where id = ?", id);
    }
}
