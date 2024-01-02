package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@CrossOrigin(origins ="http://localhost:4200")
@Controller
public class ProductController {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	Product p;
	
	@PostMapping("/addproduct")
	@ResponseBody
	public String addproduct(@RequestBody Product p) 
	{
		repo.save(p);
		return "product Created";
	}
	
	@GetMapping("/products")
	@ResponseBody
	public List<Product> viewproducts(Product p) 
	{
		
		return repo.findAll();
	}
	
//	@RequestMapping("/products")
//	public ModelAndView viewproducts()
//	{
//		List<Product> pd = (ArrayList<Product>)repo.findAll();
//		ModelAndView mv = new ModelAndView("Display.jsp");
//		mv.addObject("product", pd);
//		return mv;
//	}
	
	
	@RequestMapping("/viewproduct/{pid}")
	@ResponseBody
	public String getproduct(@PathVariable("pid") String pid) 
	{
		
		return repo.findById(pid).toString();
	}
	
	@DeleteMapping("/deleteproduct/{pid}")
	@ResponseBody
	public String deleteproduct(@PathVariable("pid") String pid) 
	{
		
		repo.deleteById(pid);
		return "Product Deleted";
	}
	
	

}
