package com.softserveinc.retail.shopping.service;

import com.softserveinc.retail.shopping.IngredientNotFoundException;
import com.softserveinc.retail.shopping.models.Ingredient;
import com.softserveinc.retail.shopping.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.saveAndFlush(ingredient);
    }

    public Ingredient findDishById(Integer id) {
        return  ingredientRepository.findById(id).orElseThrow(IngredientNotFoundException::new);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        if (ingredientRepository.existsById(ingredient.getId())) {
            return ingredientRepository.saveAndFlush(ingredient);
        }
        throw new IngredientNotFoundException();
    }
}
