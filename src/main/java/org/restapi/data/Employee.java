package org.restapi.data;

//POJO--Plain old java Object
public class Employee {
	String name;
	String salary;
	String age;
	String id;
	
	public Employee()
	{
		
	}

	public Employee(String name, String salary, String age, String id) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
