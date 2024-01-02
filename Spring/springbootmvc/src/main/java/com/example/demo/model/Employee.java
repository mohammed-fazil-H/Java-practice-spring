package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int eid=101;
	private String eName="Fazil";
	private int salary=10000;
	private String dept="It";

	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eName=" + eName + ", salary=" + salary + ", dept=" + dept + "]";
	}

}
