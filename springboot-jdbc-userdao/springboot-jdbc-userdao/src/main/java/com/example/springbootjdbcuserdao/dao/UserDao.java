package com.example.springbootjdbcuserdao.dao;

import com.example.springbootjdbcuserdao.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        this.jdbcTemplate.update("INSERT INTO USERS(id, name, password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public void deleteAll() {
        this.jdbcTemplate.update("DELETE FROM users");
    }

    public void deleteById(String id) {
        this.jdbcTemplate.update("DELETE * from users where id = ?", id);
    }
}
