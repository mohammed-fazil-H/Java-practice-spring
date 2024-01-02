package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int eid;
	private String eName;
	private int salary;
	private String dept;

	
	
	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
	}



	public String geteName() {
		return eName;
	}



	public void seteName(String eName) {
		this.eName = eName;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eName=" + eName + ", salary=" + salary + ", dept=" + dept + "]";
	}

}
