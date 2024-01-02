package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repo.Repository;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final Repository productRepo;
	
	public void createNewProduct(ProductRequest productRequest)
	{
		Product p=new Product();
		p.setProductName(productRequest.getProductName());
		p.setProductPrice(productRequest.getProductPrice());
		p.setProductQuantity(productRequest.getProductQuantity());
		
		productRepo.save(p);
		
//		Product p = Product.builder()
//				.productName(productRequest.getProductName())
//				.productPrice(productRequest.getProductPrice())
//				.productQuantity(productRequest.getProductQuantity())
//				.build();
//		productRepo.save(p);
	}
	public List<ProductResponse> getProducts()

	{

		List<Product> products = productRepo.findAll();

		List<ProductResponse> responseProduct = new ArrayList<>();

		for(Product p: products)

		{

			responseProduct.add(mapToProductResponse(p));

		}

		return responseProduct;		

	}

	private ProductResponse mapToProductResponse(Product pro)

	{
		ProductResponse ps = new ProductResponse();	
		ps.setProductId(pro.getProductId());
		ps.setProductName(pro.getProductName());
		ps.setProductPrice(pro.getProductPrice());
		ps.setProductQuantity(pro.getProductQuantity());

		return ps;

	}

}
