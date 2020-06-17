package com.softserveinc.retail.shopping;

import com.softserveinc.retail.shopping.dal.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.softserveinc.retail.shopping.dal")
public class ShoppingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Autowired
	private RestaurantDAO restaurantDAO;

	@Override
	public void run(String... args) throws Exception {
		restaurantDAO.getRestaurants();
	}
}
