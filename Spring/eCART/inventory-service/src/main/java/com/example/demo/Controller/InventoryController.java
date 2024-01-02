package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.InventoryService;
import com.example.demo.dto.RequestInventory;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController 
{
	private final InventoryService inventoryService;
	@GetMapping
	public List<RequestInventory> isInStock(@RequestParam List<String> productName)
	{
		return inventoryService.isInStock(productName) ;
	}

}
