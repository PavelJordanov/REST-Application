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
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setGroup(rs.getString("prodgroup"));
            return product;
        }

    }

    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product", new ProductRowMapper());
    }

    public Product findById(String id) {
        // return jdbcTemplate.queryForObject("select * from product where id=?", new BeanPropertyRowMapper<>(Product.class), id);
        return jdbcTemplate.queryForObject("select * from product where id=?", new ProductRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from product where id=?", id);
    }

    public int insert(Product product) {
        return jdbcTemplate.update("insert into product (id, name, prodgroup) values(?,  ?, ?)",
                product.getId(), product.getName(), product.getGroup());
    }

    public int update(Product product) {
        return jdbcTemplate.update("update product set name = ?, prodgroup = ? where id = ?",
                product.getName(), product.getGroup(), product.getId());
    }

}