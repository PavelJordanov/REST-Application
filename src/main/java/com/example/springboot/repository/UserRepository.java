package com.example.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setDob(rs.getString("dob"));
            return user;
        }

    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }

    public User findById(String id) {
        return jdbcTemplate.queryForObject("select * from user where id=?", new UserRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from user where id=?", id);
    }

    public int insert(User user) {
        return jdbcTemplate.update("insert into user (firstname, lastname, dob, username, password id) values(?, ?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getDob(), user.getUsername(), 
                user.getPassword(), user.getId());
    }

    public int update(User user) {
        return jdbcTemplate.update("update user set firstname = ?, lastname = ?, dob = ?, username = ?, password = ?, where id = ?",
            user.getFirstName(), user.getLastName(), user.getDob(), user.getUsername(), 
            user.getPassword(), user.getId());
    }

}