package com.springboot.babylion.dao;

import com.springboot.babylion.domain.UserMainInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

//NullPointerException... mysql과 연결이 안되었나...

@SpringBootTest
class UserDaoTest {

    @Autowired //UserDao 에 @Component가 있어 bean으로 등록되어 있음.
    UserDao userDao;

    @Test
    @DisplayName("쿼리 등록 test")
    void addTest() throws SQLException, ClassNotFoundException{

        UserMainInfo testUser = new UserMainInfo("khn1135", "1234","khn1135@gmail.com", "김하늘", "pigeon2gugu");
        userDao.addUser(testUser);

    }

    @Test
    @DisplayName("쿼리 삭제 test")
    void deleteTest() throws SQLException, ClassNotFoundException{

        UserMainInfo testUser = new UserMainInfo("khn1135", "1234","khn1135@gmail.com", "김하늘", "pigeon2gugu");
        userDao.deleteUser(testUser);

    }

    @Test
    @DisplayName("id 중복 test")
    void checkDuplication() throws SQLException, ClassNotFoundException{

        System.out.println(userDao.checkDuplication("id", "khn1135"));

    }
}