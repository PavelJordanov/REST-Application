package com.example.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Subscription;

@Repository
public class SubscriptionRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class SubscriptionRowMapper implements RowMapper<Subscription> {
        @Override
        public Subscription mapRow(ResultSet rs, int rowNum) throws SQLException {
            Subscription subscription = new Subscription();
            subscription.setId(rs.getString("id"));
            subscription.setUid(rs.getString("uid"));
            subscription.setPid(rs.getString("pid"));
            subscription.setStart(rs.getString("start_date"));
            subscription.setEnd(rs.getString("end_date"));
            subscription.setPrice(rs.getInt("price"));
            return subscription;
        }

    }

    public List<Subscription> findAll() {
        System.out.println("HERE3!!!");
        return jdbcTemplate.query("select * from subscriptions", new SubscriptionRowMapper());
    }

    public Subscription findById(String id) {
        return jdbcTemplate.queryForObject("select * from subscriptions where id=?", new SubscriptionRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from subscriptions where id=?", id);
    }

    public int insert(Subscription subscription) {
        return jdbcTemplate.update("INSERT INTO subscriptions (id, uid, pid, start_date, end_date, price) VALUES (?, ?, ?, ?, ?, ?)",
            subscription.getId(), subscription.getUid(), subscription.getPid(), subscription.getStart(), subscription.getEnd(), subscription.getPrice()
        );
    }

}
