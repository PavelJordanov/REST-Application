package com.example.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.User;

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
            user.setPassword(rs.getString("pwd"));
            user.setDob(rs.getString("dob"));
            user.setWeight(rs.getDouble("weight"));
            user.setHeight(rs.getDouble("height"));
            user.setFitnessGoal(rs.getString("fitness_goal"));
            user.setPlanID(rs.getString("planID")); // Correct field name
            user.setStart(rs.getString("start_date"));
            user.setEnd(rs.getString("end_date"));
            return user;
        }

    }

    public List<User> findAll() {
        System.out.println("HERE3!!!");
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    public User findById(String id) {
        return jdbcTemplate.queryForObject("select * from users where id=?", new UserRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from users where id=?", id);
    }

    public int insert(User user) {
        return jdbcTemplate.update("INSERT INTO users (firstname, lastname, dob, username, pwd, id, weight, height, fitness_goal, planID, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            user.getFirstname(), user.getLastname(), user.getDob(), user.getUsername(), 
            user.getPassword(), user.getId(), user.getWeight(), user.getHeight(), user.getFitnessGoal(), user.getPlanID(),
            user.getStart(), user.getEnd()
        );
    }

    public int update(User user) {
        return jdbcTemplate.update(
            "UPDATE users SET firstname = ?, lastname = ?, dob = ?, username = ?, pwd = ?, weight = ?, height = ?, fitness_goal = ?, planID = ?, start_date = ?, end_date = ? WHERE id = ?",
            user.getFirstname(), user.getLastname(), user.getDob(), user.getUsername(), 
            user.getPassword(), user.getWeight(), user.getHeight(), user.getFitnessGoal(), user.getPlanID(), user.getStart(), user.getEnd(), user.getId()
        );
    }
    

}