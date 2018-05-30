package com.posh.attendenceEmployee.service;

import com.posh.attendenceEmployee.model.Employee;

public interface EmployeeService {

	public Employee findUserByUserName(String userName);
	public void saveUser(Employee user);
	
}
