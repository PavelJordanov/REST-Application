package com.example.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Payment;

@Repository
public class PaymentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class PaymentRowMapper implements RowMapper<Payment> {
        @Override
        public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Payment payment = new Payment();
            payment.setId(rs.getString("id"));
            payment.setUid(rs.getString("uid"));
            payment.setType(rs.getString("type"));
            payment.setAmount(rs.getInt("amount"));
            payment.setDate(rs.getString("date"));
            return payment;
        }
    }

    public List<Payment> findAll() {
        System.out.println("HERE3!!!");
        return jdbcTemplate.query("select * from payments", new PaymentRowMapper());
    }

    public Payment findById(String id) {
        return jdbcTemplate.queryForObject("select * from payments where id=?", new PaymentRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from payments where id=?", id);
    }

    public int insert(Payment payment) {
        return jdbcTemplate.update("INSERT INTO payments (id, uid, type, amount, date) VALUES (?, ?, ?, ?, ?)",
            payment.getId(), payment.getUid(), payment.getType(), payment.getAmount(), payment.getDate());
    }
}
