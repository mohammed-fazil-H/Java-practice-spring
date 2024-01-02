package com.example.demo.dto;

//import com.example.demo.Model.Inventory;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInventory {
	
	private String productName;
	private boolean quantity;

}
