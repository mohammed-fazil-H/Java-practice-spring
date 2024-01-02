package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Person;
import com.example.demo.repo.PersonRepo;

@Controller
public class PersonController {
	
	@Autowired
	private Person person;
	
	@Autowired
	private PersonRepo repo;
	
	
	@RequestMapping("/")
	public String home() {
		return "Index.jsp";
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String createPerson(Person p)
	{
//		person.setName("Fazil");
//		person.setHobby("Running");
		
		repo.save(p);
		return "Person Create";
	}
	
	@RequestMapping("/view")
    @ResponseBody
	public String viewPerson()
	{
		return repo.findAll().toString();
	}

}
