package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Inventory;
import java.util.List;


public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
	
	List<Inventory> findByProductNameIn(List<String> productName);
	

}
