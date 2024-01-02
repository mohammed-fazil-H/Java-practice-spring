package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Inventory;
import com.example.demo.Repo.InventoryRepo;
import com.example.demo.dto.RequestInventory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	
	private final InventoryRepo inventoryRepo;
	public List<RequestInventory> isInStock(List<String> productName)
	{
		List<Inventory> iList = inventoryRepo.findByProductNameIn(productName);
		List<RequestInventory> rList = iList.stream().map(product->mapToRequestInventory(product)).toList();
		return rList;
	}
	
	public RequestInventory mapToRequestInventory(Inventory inv)
	{
		return RequestInventory.builder()
				.productName(inv.getProductName())
				.quantity(inv.getQuantity()>0)
				.build();
	}

}
