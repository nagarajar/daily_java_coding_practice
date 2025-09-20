package com.interview.practice.a.epam.employee;

import java.util.Objects;

public class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	//Practice I am typing
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//hashCode and equals method
	@Override
	public int hashCode() {
//		return id;
		return Objects.hash(id);
//		return Objects.hash(id,name,salary);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		
		if(o == this)
			return true;
		
		Employee e = (Employee)o;
		return this.id == e.id;
//		return this.id == e.id && this.name.equals(e.name) && this.salary == e.salary;	
			
	}
	
	@Override
	public String toString() {
		return "Employee: { id="+id+", name="+name+", salary="+salary+" }";
	}
}
