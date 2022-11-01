package com.springboot.babylion.domain;

//회원가입 후 db에 저장할 user info

public class UserMainInfo {
    private String id;
    private String password;
    private String email;
    private String name;
    private String nickname;

    public UserMainInfo(String id, String password, String name, String email, String nickname) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    /* users table
    CREATE TABLE `babylion-db`.`users` (
  `id` VARCHAR(12) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`));
     */
}
