package com.example.springrowmapping.repository;

import com.example.springrowmapping.CustomerRowMapper;
import com.example.springrowmapping.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Customer> findAll(){
        String sql = "SELECT * FROM CUSTOMER";
        return  jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Customer(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("age")
                        )
        );
    }
    public Customer findByCustomerId(Long id){
        String sql = "SELECT * FROM CUSTOMER WHERE id= ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerRowMapper());
    }

    public void save(Customer customer) {
        String sql = "INSERT INTO Customers VALUES (?,?,?)";
        jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getAge());
    }
}
