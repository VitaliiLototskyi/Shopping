package com.softserveinc.retail.shopping.dal;

import com.softserveinc.retail.shopping.models.RestaurantEntity;
import com.softserveinc.retail.shopping.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RestaurantDAO {
    private static final  RestaurantMapper RESTAURANT_MAPPER = new RestaurantMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void getRestaurants() {
        jdbcTemplate.execute("select * from restaurants");
    }

    public RestaurantEntity getRestaurantById(Integer id) {
        SqlParameterSource  namedParameters = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject("select * from restaurants where id = :id",namedParameters, RESTAURANT_MAPPER);
    }

    public RestaurantEntity getRestaurant(RestaurantEntity entity) {
        SqlParameterSource  namedParameters = new BeanPropertySqlParameterSource(entity);

        return namedParameterJdbcTemplate.queryForObject("select * from restaurants where id = :id and name = :name ",namedParameters, RESTAURANT_MAPPER);
    }



    static class RestaurantMapper implements RowMapper<RestaurantEntity> {
        @Override
        public RestaurantEntity mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            return new RestaurantEntity(resultSet.getInt("id"),resultSet.getString("name"));
        }
    }
}
