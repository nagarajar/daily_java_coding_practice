package com.interview.practice.a.epam.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Java8StreamsQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Task: Employee Processing with Streams

		Create a program that processes a list of Employee objects using Java 8 features.

		Requirements:

		1. Define an Employee class with attributes:
		   - id (int)
		   - name (String)
		   - salary (double)

		2. Create a list of employees.

		3. Implement the following functionalities using Java 8 Streams:
		   - Print the names of employees whose salary is above a certain threshold (e.g., 5000).
		   - Create a new list containing employees with a salary increase of 10%.
		   - Find the employee with the highest salary using Stream API.
		*/
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Nagaraja", 10000.00, "DEV"));
		empList.add(new Employee(102, "Kiran", 50000.00, "QA"));
		empList.add(new Employee(103, "Sagar", 30000.00, "DEV"));
		empList.add(new Employee(104, "Arun", 70000.00, "QA"));
		empList.add(new Employee(105, "Mahesh", 40000.00, "SIT"));
		empList.add(new Employee(106, "Lokesh", 80000.00, "SIT"));
		
		//- Print the names of employees whose salary is above a certain threshold (e.g., 5000).
		empList.stream().filter(e -> e.getSalary() > 50000).map(Employee::getName).forEach(System.out::println);
		
		empList.stream().filter(e -> e.getSalary() > 50000).forEach(e -> System.out.println(e.getName()));
		System.out.println("********************************************************************");
		
		//- Create a new list containing employees with a salary increase of 10%.
		//Way -1
//		empList.stream().forEach(e -> e.setSalary(e.getSalary() * 1.1)); // Not recomanded bcs it will modify the existing employee
		
		//Way -2
//		List<Employee> empListSalBy10Percent = empList.stream().peek(e -> e.setSalary(e.getSalary() * 1.1)).collect(Collectors.toList());
//		empListSalBy10Percent.forEach(System.out::println); // Not recomanded bcs it will modify the existing employee
		
		//Way -3
		List<Employee> empListSalBy10Percent = empList.stream().map(e -> new Employee(e.getId(), e.getName(), e.getSalary()*1.1, e.getDept())).collect(Collectors.toList());
		empListSalBy10Percent.forEach(System.out::println);
		System.out.println("********************************************************************");
		empList.forEach(System.out::println);
		System.out.println("********************************************************************");
		
		// - Find the employee with the highest salary using Stream API.
	
		// Way -1: Using stream().max()
		// ✅ Time Complexity: O(n) — single pass through the list
		// ✅ Space Complexity: O(1) — no extra data structures used
		Employee highestSalary = empList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null); //
		System.out.println(highestSalary); //Time
		
		// Way -2: Using stream().sorted().findFirst()
		// ❌ Time Complexity: O(n log n) — entire list is sorted
		// ❌ Space Complexity: O(n) — sorting creates a new list internally
		Employee highestSalary1 = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().orElse(null);
		System.out.println(highestSalary1);
		
		// Way -3: Using stream().sorted().limit(1).collect()
		// ❌ Time Complexity: O(n log n) — sorting still required
		// ❌ Space Complexity: O(n) — sorting + small result list
		List<Employee> highestSalary2 = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1).collect(Collectors.toList());
		System.out.println(highestSalary2);
		
		System.out.println("********************************************************************");
		
		//Get the employee who owns more than average salary from the employee list.
		Double avarageSalary = empList.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
		System.out.println("avarageSalary = "+avarageSalary);
		
		empList.stream().filter(e -> e.getSalary()> avarageSalary).forEach(System.out::println);
		System.out.println("********************************************************************");
		
		//From the employee list create a map which includes key as employee ID value as employee name.
		Map<Integer, String> empMap = empList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
//		Map<Integer, String> empMap = empList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName, (e,n)->e));
		System.out.println("empMap = "+empMap);
		System.out.println("********************************************************************");
		
		//From the employee list get the highest salary by department wise.
		Map<String, Double> empDeptMapWithMaxSalary = empList.stream().collect(
				Collectors.groupingBy(Employee::getDept, 
				Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)), 
						e -> e.get().getSalary())
						)
				);
		System.out.println("empDeptMapWithMaxSalary = "+empDeptMapWithMaxSalary);
		
		System.out.println("********************************************************************");
		
		//print the emp whose sal > avg(sal) of there dept
		Map<String, Double> deptAvgSalMap = empList.stream().collect(
				Collectors.groupingBy(Employee::getDept, 
						Collectors.averagingDouble(Employee::getSalary))
				);
		System.out.println(deptAvgSalMap);
		empList.stream().filter(
				e -> e.getSalary() > deptAvgSalMap.get(e.getDept())
				).forEach(System.out::println);
	}

}
