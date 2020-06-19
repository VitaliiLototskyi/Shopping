package com.softserveinc.retail.shopping;

import com.softserveinc.retail.shopping.dal.RestaurantDAO;
import com.softserveinc.retail.shopping.models.Dish;
import com.softserveinc.retail.shopping.models.RestaurantEntity;
import com.softserveinc.retail.shopping.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@ComponentScan("com.softserveinc.retail.shopping.dal")
@EnableJpaRepositories(basePackages = "com.softserveinc.retail.shopping.repository")
public class ShoppingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private DishRepository dishRepository;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(restaurantDAO.getRestaurant(new RestaurantEntity(1, "first lviv coronovirusarnia")));
//		dishRepository.save(new Dish("Soup"));
		List<Dish> dishes =  dishRepository.fetchDishesById(1);
		System.out.println(dishes.get(0).getName());
	}
}
