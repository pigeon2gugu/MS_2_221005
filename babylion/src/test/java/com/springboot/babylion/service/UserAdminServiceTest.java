package com.springboot.babylion.service;

import com.springboot.babylion.dao.UserDao;
import com.springboot.babylion.domain.UserMainInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAdminServiceTest {
    @Autowired //UserDao 에 @Component가 있어 bean으로 등록되어 있음.
    UserDao userDao;

    @Test
    @DisplayName("회원가입 test")
    void addTest() throws SQLException, ClassNotFoundException{

        UserAdminService uas = new UserAdminService(userDao);

        UserMainInfo testUser = new UserMainInfo("khn1135", "1234", "김하늘", "khn1135@gmail.com", "pigeon2gugu");

        //중복 id에서 걸러져 나옴. testUser = 이미 등록된 id
        uas.joinMember(testUser.getId(), testUser.getPassword(), "1234", testUser.getName(), testUser.getEmail(), testUser.getNickname());

        //비밀번호 오류
        uas.joinMember("khn1111", testUser.getPassword(), "1111", testUser.getName(), testUser.getEmail(), testUser.getNickname());

        //중복 email
        uas.joinMember("khn1111", testUser.getPassword(), "1234", testUser.getName(), testUser.getEmail(), testUser.getNickname());

        //중복 nickname
        uas.joinMember("khn1111", testUser.getPassword(), "1234", testUser.getName(), "hn9715@naver.com", testUser.getNickname());
    }

    @Test
    @DisplayName("로그인 test and 닉네임 변경")
    void loginTest() throws SQLException, ClassNotFoundException {
        UserAdminService uas = new UserAdminService(userDao);

        //로그인 성공
        UserMainInfo loginUser = uas.login("khn1135", "1234");

        //로그인 실패
        UserMainInfo loginUser2 = uas.login("khn1135", "111");
        System.out.println(loginUser2);
        
        //닉네임 변경. 이 때 loginUser에 null이 들어가면 어떡하나.
        loginUser = uas.changeNickname(loginUser, "gugu");
        System.out.println(loginUser.getNickname());

        //현재 닉네임과 동일
        loginUser = uas.changeNickname(loginUser, "pigeon2gugu");
        System.out.println(loginUser.getNickname());

    }

}