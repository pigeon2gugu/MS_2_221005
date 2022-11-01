package com.springboot.babylion.controller;

import com.springboot.babylion.dao.UserDao;
import com.springboot.babylion.domain.UserMainInfo;

import java.sql.SQLException;

public class UserAdminController {
    private final UserDao userDao;

    public UserAdminController(UserDao userDao) {
        this.userDao = userDao;
    }


    //로그인... 로그인 한 후 회원 정보는 어떻게 저장할까... (게시글 작성에 필요한 아이디 정보를 위한 것)
    //회원정보 변경

}
