package com.springboot.babylion.controller;

import com.springboot.babylion.dao.UserAdmin;
import com.springboot.babylion.domain.UserMainInfo;

import java.sql.SQLException;

public class UserAdminController {
    private final UserAdmin userAdmin;

    public UserAdminController(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }

    //회원가입 method
    public int joinMember(String id, String password, String passwordAgain, String name, String email, String nickname) throws SQLException, ClassNotFoundException {
        // 0 : 회원가입 실패 , 1 : 회원가입 성공

        if (userAdmin.checkDuplication("id", id) != 0) {
            System.out.println("중복된 id 입니다.");
            return 0; //나중에 혹여 모를 웹서비스에서의 동작을 위한 return값. 웹에서 동작한다면 중복체크들은 다른 class로 분리 되겠지...?
        }

        if (userAdmin.checkDuplication("email", email) != 0) {
            System.out.println("중복된 email 입니다.");
            return 0;
        }

        if (userAdmin.checkDuplication("nickname", nickname) != 0) {
            System.out.println("중복된 nickname 입니다.");
            return 0;
        }

        if (password != passwordAgain) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return 0;
        }

        UserMainInfo userMainInfo = new UserMainInfo(id, password, name, email, nickname);
        userAdmin.addUser(userMainInfo);
        System.out.println("회원가입 성공");
        return 1;
    }

    //회원탈퇴 method
    public int cancleMember(String id, String password) throws SQLException, ClassNotFoundException {
        // 0 : 회원탈퇴 실패 , 1 : 회원탈퇴 성공

        if (userAdmin.checkPassword(id, password) != 1) {
            System.out.println("비밀번호를 확인하세요");
            return 0;
        }

        userAdmin.deleteUser(id);
        System.out.println("회원탈퇴 성공");
        return 1;

    }

    //로그인... 로그인 한 후 회원 정보는 어떻게 저장할까... (게시글 작성에 필요한 아이디 정보를 위한 것)
    //회원정보 변경

}
