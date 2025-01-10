package com.example.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.User;
import com.example.springboot.model.UserBalance;

@Repository
public class UserBalanceRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class UserBalanceRowMapper implements RowMapper<UserBalance> {
        @Override
        public UserBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserBalance userBalance = new UserBalance();
            userBalance.setId(rs.getString("id"));
            userBalance.setUid(rs.getString("uid"));
            userBalance.setBalance(rs.getInt("balance"));
            return userBalance;
        }
    }

    public List<UserBalance> findAll() {
        System.out.println("HERE3!!!");
        return jdbcTemplate.query("select * from userbalances", new UserBalanceRowMapper());
    }

    public UserBalance findById(String id) {
        return jdbcTemplate.queryForObject("select * from userbalances where id=?", new UserBalanceRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from userbalances where id=?", id);
    }

    public int insert(UserBalance userBalance) {
        return jdbcTemplate.update("INSERT INTO userbalances (id, uid, balance) VALUES (?, ?, ?)",
            userBalance.getId(), userBalance.getUid(), userBalance.getBalance());
    }

    public int update(UserBalance userBalance) {
        return jdbcTemplate.update(
            "UPDATE userbalances SET id = ?, uid = ?, balance = ? WHERE id = ?",
            userBalance.getId(), userBalance.getUid(), userBalance.getBalance()
        );
    }
}
