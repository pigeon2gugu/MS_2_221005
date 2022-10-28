package com.example.springbootjdbcuserdao.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.id, this.name, this.password);
    }
}
