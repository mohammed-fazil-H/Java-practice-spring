package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;

@Controller
public class MyHomeController {
	@Autowired
	Employee emp;
	
	@RequestMapping("/")
	public String Homepage()
	{
		return "Index.jsp";
	}
	
//	@RequestMapping("/display")
//	public ModelAndView display(String uname)
//	{
//		ModelAndView mv= new ModelAndView("display.jsp");
//		mv.addObject("uName",uname);
//				
//		return mv ;
	
	@RequestMapping("/display")
	public ModelAndView display(String uname)
	{
		ModelAndView mv= new ModelAndView("display.jsp");
		mv.addObject("emp",emp);
				
		return mv ;
		
	}

}
