package com.example.demo.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.example.demo.Repo.OrderRepo;
import com.example.demo.dto.OrderLineItemsDto;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.RequestInventory;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLineItems;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final WebClient.Builder webClientBuilder;
	
	private final OrderRepo orderRepo;
	public String placeOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
		String msg;
		
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(dto ->mapToDto(dto)).toList());
		//orderRepo.save(order);
		

		List<String> productNames = order.getOrderLineItems().stream().map(orderItemList->orderItemList.getProductName()).toList();
		RequestInventory[] inventoryResponseArray= webClientBuilder.build().get()
				.uri("http://inventory-service/inventory",uriBuilder ->uriBuilder.queryParam("productName", productNames).build())
				.retrieve()
				.bodyToMono(RequestInventory[].class).block();
		
		boolean stockCheckStatus = Arrays.stream(inventoryResponseArray).allMatch(inventory->inventory.isQuantity());
		
		
		if(stockCheckStatus) 
		{
			orderRepo.save(order);
			msg="Order placed successfully!!";
		}
		else 
		{
			msg="some of the product are out of stock...!";
			throw new IllegalArgumentException("some of the product are out of stock...!");
		}
		
		 return msg;
	    
	}
	
	public OrderLineItems mapToDto(OrderLineItemsDto dto)
	{
		return OrderLineItems.builder()
//				.id(dto.getProductId())
				.productName(dto.getProductName())
				.price(dto.getProductPrice())
				.quantity(dto.getProductQuantity())
				.build();
				
	}
	
//	public List<ProductResponse> getAllProductsList()
//	{
//		ProductResponse[] productList = webClient.get().uri("http://localhost:8001/product")
//				.retrieve()
//				.bodyToMono(ProductResponse[].class)
//				.block();
//	}
	

}
