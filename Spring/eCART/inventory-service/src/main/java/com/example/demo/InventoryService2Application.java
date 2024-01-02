package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.Model.Inventory;
import com.example.demo.Repo.InventoryRepo;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryService2Application {
	
	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo)
	{
		return args ->{
			Inventory phone = Inventory.builder().build();
			
			phone.setProductName("Moto");
			phone.setQuantity(9);
					
			inventoryRepo.save(phone);
			
			
			Inventory Laptop = Inventory.builder().build();
			
			Laptop.setProductName("Dell");
			Laptop.setQuantity(9);
					
			inventoryRepo.save(Laptop);
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryService2Application.class, args);
	}

}
