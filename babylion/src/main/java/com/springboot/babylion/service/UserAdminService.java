package com.springboot.babylion.service;

import com.springboot.babylion.dao.UserDao;
import com.springboot.babylion.domain.UserMainInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class UserAdminService {
    private final UserDao userDao;

    public UserAdminService(UserDao userDao) {
        this.userDao = userDao;
    }

    //회원가입 method
    public int joinMember(String id, String password, String passwordAgain, String name, String email, String nickname) throws SQLException, ClassNotFoundException {
        // 0 : 회원가입 실패 , 1 : 회원가입 성공

        if (userDao.checkDuplication("id", id) != 0) {
            System.out.println("중복된 id 입니다.");
            return 0; //나중에 혹여 모를 웹서비스에서의 동작을 위한 return값. 웹에서 동작한다면 중복체크들은 다른 class로 분리 되겠지...?
        }

        if (password != passwordAgain) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return 0;
        }

        if (userDao.checkDuplication("email", email) != 0) {
            System.out.println("중복된 email 입니다.");
            return 0;
        }

        if (userDao.checkDuplication("nickname", nickname) != 0) {
            System.out.println("중복된 nickname 입니다.");
            return 0;
        }

        UserMainInfo userMainInfo = new UserMainInfo(id, password, name, email, nickname);
        userDao.addUser(userMainInfo);
        System.out.println("회원가입 성공");
        return 1;
    }

    //회원탈퇴 method
    public int cancleMember(UserMainInfo user, String password) throws SQLException, ClassNotFoundException {
        // 0 : 회원탈퇴 실패 , 1 : 회원탈퇴 성공

        if (userDao.checkPassword(user.getId(), password) != 1) {
            System.out.println("비밀번호를 확인하세요.");
            return 0;
        }

        userDao.deleteUser(user);
        System.out.println("회원탈퇴 성공");
        return 1;

    }

    //로그인 method 로그인 실패시 null을 return하는 방식이 맞을까... (user return방식이 맞을지)
    //로그인시 반환된 UserMainInfo는 어디에 저장해서 사용해야 하는가...
    //이 때 loginUser에 null이 들어가면 어떡하나. -> 닉네임 변경시 오류남.

    public UserMainInfo login(String id, String password) throws SQLException, ClassNotFoundException {
        if (userDao.checkPassword(id, password) != 1) {
            System.out.println("아이디나 비밀번호를 확인하세요.");
            return null;
        }

        System.out.println("로그인 성공");
        return userDao.findById(id);
    }

    //닉네임변경 method 저장된 UserMainInfo를 변경해준다.
    public UserMainInfo changeNickname(UserMainInfo user, String changeNickname) throws SQLException, ClassNotFoundException {

        //왜 ==이 안먹히는가... equal을 써야 한다...?
        if (changeNickname.equals(user.getNickname())) {
            System.out.println("현재와 동일한 닉네임 입니다.");
            return user;
        }

        if (userDao.checkDuplication("nickname", changeNickname) != 0) {
            System.out.println("이미 있는 닉네임 입니다.");
            return user;
        }

        userDao.modify("nickname", changeNickname, user);

        //다시 findById로 초기화해줄가... 아니면 nickname만 바꿀까...
        user = new UserMainInfo(user.getId(), user.getPassword(), user.getName(), user.getEmail(), changeNickname);
        System.out.println("닉네임 변경 성공");
        return user;

    }
}
