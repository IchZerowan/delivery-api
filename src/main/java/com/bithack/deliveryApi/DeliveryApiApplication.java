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

			Dish dish1 = new Dish("Cheese-Bro", "cheese-bro.png", "Свіжа булочка власного виробництва, соус BBQ, соковита яловичина, солоний огірок, сир Гауда.", 39d, category1);
			dishRepository.save(dish1);

			Dish dish11 = new Dish("Italian-Bro", "italian-bro.png", "Яловича котлета, булочка, соус 1000 островів, солодке цибулеве варення, солоний огірок, салат айсберг, сир гауда.", 66d, category1);
			dishRepository.save(dish11);

			Category category11 = new Category("Shavarma", company1);
			categoryRepository.save(category11);

			Dish dish111 = new Dish("Chicken Shavarma XL", "chicken-shavarma-xl.png", "М`ясо курочки, капуста, огірок, помідор, трішки корейської моркви, соус білий з часником, соус BBQ.", 75d, category11);
			dishRepository.save(dish111);

			Company company2 = new Company("ХОЧУ ПІЦУ", "піцерія");
			companyRepository.save(company2);

			Category category2 = new Category("Pizzas", company2);
			categoryRepository.save(category2);

			Dish dish2 = new Dish("Margherita", "margherita.png", "Моцарела, свіжі томати, базилік, оливкова олія, ароматний фірмовий соус. ", 89d, category2);
			dishRepository.save(dish2);

			Dish dish3 = new Dish("Hawaii", "hawai.png", "Моцарела, ананас консервований, ніжне філе курки, ароматний фірмовий соус. ", 109d, category2);
			dishRepository.save(dish3);

			Category category22 = new Category("Calzone", company2);
			categoryRepository.save(category22);

			Dish dish33 = new Dish("Chiken-bekon calzone", "calzone-chicken-bekon.png", "Моцарелла, ніжне куряче філе, бекон, фірмовий томатний соус, орегано сушений. ", 79d, category22);
			dishRepository.save(dish33);

			Company company3 = new Company("Wings!", "ресторан");
			companyRepository.save(company3);

//			OrderM orderM = new OrderM(100d, "+380999999999", "Ihor");
//			orderRepository.save(orderM);
		};
	}
}
