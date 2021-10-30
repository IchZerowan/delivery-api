package com.bithack.deliveryApi;

import com.bithack.deliveryApi.dao.CategoryRepository;
import com.bithack.deliveryApi.dao.CompanyRepository;
import com.bithack.deliveryApi.dao.DishRepository;
import com.bithack.deliveryApi.dao.OrderRepository;
import com.bithack.deliveryApi.model.Category;
import com.bithack.deliveryApi.model.Company;
import com.bithack.deliveryApi.model.Dish;
import com.bithack.deliveryApi.model.OrderM;
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

	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDeliveries(){
		return args -> {
			Company company1 = new Company("Da!Bro", "ресторан");
			companyRepository.save(company1);

			Category category1 = new Category("Burgers", company1);
			categoryRepository.save(category1);

			Dish dish1 = new Dish("Cheeseburger", "cheeseburger.jpg", "Tasty Cheeseburger", 50d, category1);
			dishRepository.save(dish1);


			Company company2 = new Company("ХОЧУ ПІЦУ", "піцерія");
			companyRepository.save(company2);

			Category category2 = new Category("Pizzas", company2);
			categoryRepository.save(category2);

			Dish dish2 = new Dish("Margherita", "margherita.jpg", "Cheese Pizza", 70d, category2);
			dishRepository.save(dish2);

			Dish dish3 = new Dish("Hawaii", "hawaii.jpg", "Hawaii Pizza", 80d, category2);
			dishRepository.save(dish3);

//			OrderM orderM = new OrderM(100d, "+380999999999", "Ihor");
//			orderRepository.save(orderM);
		};
	}
}
