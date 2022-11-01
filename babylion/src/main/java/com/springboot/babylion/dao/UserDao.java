package com.springboot.babylion.dao;

import com.springboot.babylion.domain.UserMainInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

//질문 : userDao에서 jdbcTemplate사용만 하는 방법과, 거기에 new datasource()를 해주는 방법과, yml 세팅과 환경변수 세팅의 차이점...
@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    //유저 관리 method
    public void addUser(UserMainInfo user) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("INSERT INTO users(id, password, name, email, nickname) values(?,?,?,?,?)",
                user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getNickname());
    }

    public void deleteUser(UserMainInfo user) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("DELETE FROM users where id = ?",
                user.getId());
    }

    public void modify(String field, String change, UserMainInfo user) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("UPDATE users SET "+field+" = ? where id = ?",
                change, user.getId());
    }

    //중복 값 체크 db값 체크하는 것인데 userdao에 있는것이 맞나... service에 들어가는것이 맞나...
    // where ? = ? error. string 결합으로 해야함.
    public int checkDuplication(String checkIndex, String checkValue) throws SQLException, ClassNotFoundException{
        String sql = "SELECT count(*) from users where "+checkIndex+" = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, checkValue);
    }

    public int checkPassword(String id, String password) throws SQLException, ClassNotFoundException{
        String sql = "SELECT count(*) from users where id = ? AND password = ?";
        return this.jdbcTemplate.queryForObject(sql, Integer.class, id, password);
    }

    //for test
    RowMapper<UserMainInfo> rowMapper = new RowMapper<UserMainInfo>() {
        @Override
        public UserMainInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserMainInfo user = new UserMainInfo(rs.getString("id"), rs.getString("password"), rs.getString("email"), rs.getString("name"), rs.getString("nickname"));
            return user;
        }
    };

    //로그인 때 활용
    public UserMainInfo findById(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from users where id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

}
