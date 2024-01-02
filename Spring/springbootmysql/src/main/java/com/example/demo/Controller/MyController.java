package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
@Controller
public class MyController {
	
	@Autowired
	Employee e;
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String Home()
	{
		return "Index.jsp";
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String Add(Employee e) {
		
		repo.save(e);
		return "Person Created";
		
	}
	@RequestMapping("/search")
	@ResponseBody
	public String search(String dept) {
		
		return repo.findByDept(dept).toString();
		
	}
//	@RequestMapping("/view")            // without modelAndView
//	@ResponseBody
//	public String view(Employee e) {
//		return repo.findAll().toString();
//	}
//	

	@RequestMapping("/view")
	public ModelAndView viewAllEmployees() {
	    String employees = repo.findAll().toString(); // Retrieve all employees from the repository
	    ModelAndView mv = new ModelAndView("displayview.jsp");
	    mv.addObject("employees", employees);
	    return mv;
	}

}
