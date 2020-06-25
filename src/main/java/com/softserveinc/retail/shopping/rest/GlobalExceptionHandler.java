package com.softserveinc.retail.shopping.rest;

import com.softserveinc.retail.shopping.DishNotFoundException;
import com.softserveinc.retail.shopping.IngredientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DishNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dish with supplied id was not found")
    public void DishNotFoundException() {

    }

    @ExceptionHandler(IngredientNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Ingredient with supplied id was not found")
    public void IngredientNotFoundException() {

    }
}
