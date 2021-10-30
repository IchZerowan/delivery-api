package com.bithack.deliveryApi;

import com.bithack.deliveryApi.dao.CompanyRepository;
import com.bithack.deliveryApi.model.Company;
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

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDeliveries(){
		return args -> {
			Company example = new Company("Da!Bro", "ресторан");
			companyRepository.save(example);
		};
	}
}
