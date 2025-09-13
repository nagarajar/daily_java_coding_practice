package streams.practice.employee;

import java.util.Objects;

public class Employee {
	//Members
	private long id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	private double salary;
	
	//Default constructor
	public Employee() {
		
	}
	
	//Parameterized Constructor
	public Employee(long id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	
	//Getters and Setters
	public void setId(long id) {
		this.id=id;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//Equal and hashCode methods
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || this.getClass()!=obj.getClass())
			return false;
		
		if(this == obj)
			return true;
		
		Employee e = (Employee)obj;
		return this.id == e.id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
		+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
}
