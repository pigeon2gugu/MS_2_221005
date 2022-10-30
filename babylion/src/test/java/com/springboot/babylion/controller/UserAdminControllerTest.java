package com.springboot.babylion.controller;

import com.springboot.babylion.dao.UserAdmin;
import com.springboot.babylion.domain.UserMainInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserAdminControllerTest {

    UserAdminController userAdminController;
    UserAdmin userAdmin;

    @Test
    @DisplayName("회원가입 test")
    void addTest() throws SQLException, ClassNotFoundException{

        int test1 = userAdminController.joinMember("khn1135", "1234", "1234", "김하늘", "khn1135@gmail.com", "pigeon2gugu");


        UserMainInfo testUser = new UserMainInfo("khn1135", "1234","khn1135@gmail.com", "김하늘", "pigeon2gugu");
        userAdmin.addUser(testUser);

        UserMainInfo selectUser = userAdmin.findById("khn1135");
        assertEquals(testUser.getName(), selectUser.getName());

    }

}