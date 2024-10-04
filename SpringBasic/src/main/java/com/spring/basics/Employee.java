package com.spring.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Employee {
	private String empName;
	private Integer empId;
	private double salary;
		
	private Address address;
	
	public String getEmpName() {
		return empName;
	}
	public Address getAddress() {
		return address;
	}
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	@Value("${employee.empName}")
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpId() {
		return empId;
	}
	@Value("${employee.empId}")
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	@Value("${employee.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", salary=" + salary + ", address=" + address
				+ "]";
	}
	
	

}
