package com.example.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Plan;

@Repository
public class PlanRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static class PlanRowMapper implements RowMapper<Plan> {
        @Override
        public Plan mapRow(ResultSet rs, int rowNum) throws SQLException {
            Plan plan = new Plan();
            plan.setId(rs.getString("id"));
            plan.setName(rs.getString("name"));
            plan.setDescription(rs.getString("description"));
            plan.setType(rs.getString("type"));
            plan.setDurationInWeeks(rs.getInt("durationInWeeks"));
            plan.setPrice(rs.getInt("price"));
            plan.setNumclients(rs.getInt("numclients"));
            return plan;
        }

    }

    public List<Plan> findAll() {
        System.out.println("HERE3!!!");
        return jdbcTemplate.query("select * from plans", new PlanRowMapper());
    }

    public Plan findById(String id) {
        return jdbcTemplate.queryForObject("select * from plans where id=?", new PlanRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from plans where id=?", id);
    }

    public int insert(Plan plan) {
        return jdbcTemplate.update("INSERT INTO plans (id, name, description, type, durationInWeeks, price, numclients) VALUES (?, ?, ?, ?, ?, ?, ?)",
            plan.getId(), plan.getName(), plan.getDescription(), plan.getType(), plan.getDurationInWeeks(), plan.getPrice(), plan.getNumclients()
        );
    }

    public int update(Plan plan) {
        return jdbcTemplate.update(
            "UPDATE plans SET name = ?, description = ?, type = ?, durationInWeeks = ?, price = ?, numclients = ? WHERE id = ?",
            plan.getName(), plan.getDescription(), plan.getType(), plan.getDurationInWeeks(), plan.getPrice(), plan.getNumclients(), plan.getId()
        );
    }
}
