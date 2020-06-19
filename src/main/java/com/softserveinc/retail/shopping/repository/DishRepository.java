package com.softserveinc.retail.shopping.repository;

import com.softserveinc.retail.shopping.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    //    Dish getDishByNameAndPriceGreaterThen(String name, Integer price);
    @Query(nativeQuery = true, value = "select * from dish where id = :id")
    List<Dish> fetchDishesById(@Param("id") Integer id);
}
