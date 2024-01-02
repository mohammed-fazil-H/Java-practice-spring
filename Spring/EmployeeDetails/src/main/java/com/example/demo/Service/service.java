package com.example.demo.Service;

import java.util.ArrayList;

import java.util.List;

import com.example.demo.model.Employee;

public class service {
	List<Employee> empList= new ArrayList<>();
			
			public void create(Employee emp)
			{
				empList.add(emp);
		
			}
}