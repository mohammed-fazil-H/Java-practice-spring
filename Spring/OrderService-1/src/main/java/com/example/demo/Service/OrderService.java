package com.example.demo.Service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.Repo.OrderRepo;
import com.example.demo.dto.OrderLineItemsDto;
import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLineItems;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class OrderService {
	private final OrderRepo orderRepo;
	public void placeOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(dto ->mapToDto(dto)).toList());
		orderRepo.save(order);
		
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

}
