package com.bithack.deliveryApi;

import com.bithack.deliveryApi.dao.CategoryRepository;
import com.bithack.deliveryApi.dao.CompanyRepository;
import com.bithack.deliveryApi.dao.DishRepository;
import com.bithack.deliveryApi.model.Category;
import com.bithack.deliveryApi.model.Company;
import com.bithack.deliveryApi.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DeliveryApiApplication {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	DishRepository dishRepository;

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDeliveries(){
		return args -> {
			Company company = new Company("Da!Bro", "ресторан");
			companyRepository.save(company);

			Category category = new Category("Burgers", company);
			categoryRepository.save(category);

			Dish dish = new Dish("Cheeseburger", "cheeseburger.jpg", "Tasty Cheeseburger", 12.50, category);
			dishRepository.save(dish);
		};
	}
}
