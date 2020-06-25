package com.softserveinc.retail.shopping.rest;

import com.softserveinc.retail.shopping.models.Ingredient;
import com.softserveinc.retail.shopping.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping(path = "/")
    public List<Ingredient> getIngredients() {
        return ingredientService.getIngredients();
    }

    @PostMapping
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }
    @PutMapping
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(ingredient);
    }

    @GetMapping(path = "/{id}")
    public Ingredient getIngredientById(@PathVariable Integer id) {
        return ingredientService.findDishById(id);
    }
}
