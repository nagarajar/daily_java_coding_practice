package streams.practice.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Using Java 8 Feature solve the below questions
		 */
		
		List<Employee> employees = getAllEmployees();
		System.out.println("size(): "+ employees.size());
		
		/*
		 * Q1. How many male and female employees are there in organization ?
		 */
		long maleCount = employees.stream().filter(e-> e.getGender().equals("Male")).count();
		System.out.println("Male count: "+maleCount);
		
		long femaleCount = employees.stream().filter(e-> e.getGender().equals("Female")).count();
		System.out.println("Female count: "+femaleCount);
		
		Map<String, Long> genderCount = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Gender count: "+genderCount);
		
		/*
		 *  Q2. Print all department names in the organization ?
		 */
		employees.forEach(e -> System.out.println(e.getDepartment()));
		List<String> departments = employees.stream().map(Employee::getDepartment).collect(Collectors.toList());
		System.out.println(departments);
		
		List<String> distinctDepartments = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		System.out.println("Distinct Departments: "+distinctDepartments);
		
		/*
		 * Q3. Get count of employees where sal > 75000, and < 75000 separate counts
		 */
		long employeesSalaryCount = employees.stream().filter(e -> e.getSalary()>75000 || e.getSalary()<75000).count();
		System.out.println("employeesSalaryCount: "+employeesSalaryCount);
		
		long countSalGreater = employees.stream().filter(e -> e.getSalary()>75000).count();
		System.out.println("countSalGreater 75000: "+ countSalGreater);
		
		long countSalLessThan = employees.stream().filter(e -> e.getSalary()<=75000).count();
		System.out.println("countSalLessThan 75000: "+ countSalLessThan);
		
		/*
		 * Q5. Sort the list of employee names
		 */
		List<String> employeeNameASC = employees.stream().map(Employee::getName).sorted().collect(Collectors.toList());
		System.out.println("employeeNameASC: "+employeeNameASC);
		
		List<String> employeeNameDSC = employees.stream().map(Employee::getName).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("employeeNameDSC: "+employeeNameDSC);
		
		/*
		 * Q6. Problem Statement: GROUP BY Department and Find Number of employees
		 */
		Map<String, Long> employeesCountByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("employeesCountByDept: "+employeesCountByDept);
		
		/*
		 * Q7. Problem Statement: GROUP BY Department and Find Max Salary
		 */
		//Step1 -> Group by Dept
		//Step2 -> Compare max salary by employee salary
		Map<String, Optional<Employee>> maxSalaryByDeptOptional = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, 
						Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println("maxSalaryByDeptOptional: "+maxSalaryByDeptOptional);
		
		//Map<Dept, Salary>
		Map<String, Double> maxSalaryByDept =  employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment,
				Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)), e-> e.get().getSalary())
						)
				);
		System.out.println("maxSalaryByDept: "+maxSalaryByDept);
		
		//Map<Dept, Employee>
		Map<String, Employee> maxSalaryByDeptWithEmployee = employees.stream().collect(
				Collectors.groupingBy(
						Employee::getDepartment,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Employee::getSalary)), 
								e -> e.get())
						)
				);
		System.out.println("maxSalaryByDeptWithEmployee:: "+maxSalaryByDeptWithEmployee);
		
		/*
		 * Q7. Problem Statement: Sort by name if name sort by age
		 */
		List<Employee> sortedByNameElseAge = employees.stream()
				.sorted(Comparator.comparing(Employee::getName)
						.thenComparing(Employee::getAge))
				.collect(Collectors.toList());
		System.out.println("sortedByNameElseAge: "+sortedByNameElseAge);
	}
	
	public static List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John", 25, "Male", "Development", 2021, 600000.00));
		employees.add(new Employee(17, "John", 27, "Male", "Testing", 2021, 500000.00));
	    employees.add(new Employee(2, "Alice", 30, "Female", "Marketing", 2018, 70000.00));
	    employees.add(new Employee(3, "Bob", 28, "Male", "Sales", 2019, 55000.00));
	    employees.add(new Employee(4, "Charlie", 35, "Male", "Development", 2015, 90000.00));
	    employees.add(new Employee(5, "David", 32, "Male", "HR", 2017, 65000.00));
	    employees.add(new Employee(6, "Eve", 27, "Female", "Marketing", 2020, 72000.00));
	    employees.add(new Employee(7, "Frank", 29, "Male", "Sales", 2018, 58000.00));
	    employees.add(new Employee(8, "Grace", 31, "Female", "Development", 2016, 85000.00));
	    employees.add(new Employee(9, "Hank", 26, "Male", "Development", 2022, 610000.00));
	    employees.add(new Employee(10, "Ivy", 33, "Female", "HR", 2014, 62000.00));
	    employees.add(new Employee(11, "Jack", 30, "Male", "Sales", 2017, 60000.00));
	    employees.add(new Employee(12, "Kate", 28, "Female", "Development", 2019, 75000.00));
	    employees.add(new Employee(13, "Liam", 34, "Male", "Marketing", 2015, 69000.00));
	    employees.add(new Employee(14, "Mia", 29, "Female", "Sales", 2020, 62000.00));
	    employees.add(new Employee(15, "Noah", 27, "Male", "HR", 2021, 68000.00));
	    employees.add(new Employee(16, "Karan", 28, "Male", "HR", 2021, 78000.00));
		
		return employees;
		
	}

}
