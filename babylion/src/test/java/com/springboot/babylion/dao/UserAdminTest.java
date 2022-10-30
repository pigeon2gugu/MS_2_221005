package com.springboot.babylion.dao;

import com.springboot.babylion.domain.UserMainInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

//NullPointerException... mysql과 연결이 안되었나...

class UserAdminTest {
    UserAdmin userAdmin;

    @Test
    @DisplayName("회원가입 test")
    void addTest() throws SQLException, ClassNotFoundException{

        UserMainInfo testUser = new UserMainInfo("khn1135", "1234","khn1135@gmail.com", "김하늘", "pigeon2gugu");
        userAdmin.addUser(testUser);

    }
}