package com.softserveinc.retail.shopping.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getRestaurants() {
        jdbcTemplate.execute("select * from restaurants");
    }
}
