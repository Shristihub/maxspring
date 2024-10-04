package com.employeeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {

	private String employeeName;
	private String city;
	private double salary;
	private Integer employeeId;
	
}
