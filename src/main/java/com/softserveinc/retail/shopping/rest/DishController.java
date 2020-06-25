package com.softserveinc.retail.shopping.rest;

import com.softserveinc.retail.shopping.DishNotFoundException;
import com.softserveinc.retail.shopping.models.Dish;
import com.softserveinc.retail.shopping.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping(path = "/")
    public List<Dish> getDishes() {
        return dishService.getDishes();
    }

    @PostMapping
    public Dish saveDish(@RequestBody Dish dish) {
         return dishService.addDish(dish);
    }
    @PutMapping
    public Dish updateDish(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
    }

    @GetMapping(path = "/{id}")
    public Dish getDishById(@PathVariable Integer id) {
        return dishService.findDishById(id);
    }
}
