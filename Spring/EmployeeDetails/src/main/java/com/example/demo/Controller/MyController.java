package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.service;
import com.example.demo.model.Employee;
import com.example.demo.service.Service;

@Controller
public class MyController {
	
	
	service s=new service();
	
	@Autowired
	Employee emp;
	
	@RequestMapping("/")
	public String Homepage()
	{
		return "Index.jsp";
	}
	
	@RequestMapping("/add")
	public String displayPage(Employee emp)
	{
		s.create(emp);
		return "Index.jsp";
		
	}

}
