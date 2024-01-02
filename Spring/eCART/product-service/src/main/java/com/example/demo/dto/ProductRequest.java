package com.example.demo.dto;

import com.example.demo.Model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	
	private String productName;
	private Double productPrice;
	private Integer productQuantity;
	

}
