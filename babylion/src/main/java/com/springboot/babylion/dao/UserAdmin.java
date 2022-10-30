package com.springboot.babylion.dao;

import com.springboot.babylion.domain.UserMainInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//user database에서 정보를 꺼내오거나 저장하는 코드는 모두 dao directory에 넣어도 되는가?


public class UserAdmin {

    private final JdbcTemplate jdbcTemplate;

    public UserAdmin(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //유저 관리 method
    public void addUser(UserMainInfo user) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("INSERT INTO users(id, password, name, email, nickname) values(?,?,?,?,?)",
                user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getPassword());
    }

    public void deleteUser(String id) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("DELETE FROM users where id = ?",
                id);
    }

    public void chanegeUserNickname(UserMainInfo user, String nickname) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("UPDATE users SET nickname = ? where id = ?",
                nickname, user.getId());
    }

    public void chanegeUserPassword(UserMainInfo user, String nickname) throws SQLException, ClassNotFoundException{
        this.jdbcTemplate.update("UPDATE users SET password = ? where id = ?",
                nickname, user.getId());
    }

    //중복 값 체크
    public int checkDuplication(String checkIndex, String checkValue) throws SQLException, ClassNotFoundException{
        String sql = "SELECT count(*) from users where ? = ?";
        return this.jdbcTemplate.queryForObject(sql, Integer.class, checkIndex, checkValue);
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

    public UserMainInfo findById(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from users where id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

}
