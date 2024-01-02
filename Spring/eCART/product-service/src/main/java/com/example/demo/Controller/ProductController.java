package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;

@RestController
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping
	public void createProduct(@RequestBody ProductRequest productRequest)
	{
		service.createNewProduct(productRequest);
	}
	
	@GetMapping
	public List<ProductResponse> getProduct()
	{
		List<ProductResponse> plist =service.getProducts();
		return  plist;
	}

}
