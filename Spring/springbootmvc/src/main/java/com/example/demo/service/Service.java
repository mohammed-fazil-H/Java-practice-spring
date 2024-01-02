package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;

import com.example.demo.model.Employee;

public class Service {
	List<Employee> empList= new ArrayList<>();
			
			public void create(Employee emp)
			{
				empList.add(emp);
		
			}
}
