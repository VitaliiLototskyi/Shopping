package com.softserveinc.retail.shopping.service;

import com.softserveinc.retail.shopping.DishNotFoundException;
import com.softserveinc.retail.shopping.models.Dish;
import com.softserveinc.retail.shopping.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getDishes(){
     return dishRepository.findAll();
    }

    public Dish addDish(Dish dish) {
        return dishRepository.saveAndFlush(dish);
    }

    public Dish findDishById(Integer id) {
        return  dishRepository.findById(id).orElseThrow(DishNotFoundException::new);
    }

    public Dish updateDish(Dish dish) {
        if (dishRepository.existsById(dish.getId())) {
            return dishRepository.saveAndFlush(dish);
        }
        throw new DishNotFoundException();
    }
}
