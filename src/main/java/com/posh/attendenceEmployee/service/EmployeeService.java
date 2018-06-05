package com.posh.attendenceEmployee.service;

import java.util.List;

import com.posh.attendenceEmployee.model.Employee;

public interface EmployeeService {

	public Employee findUserByUserName(String userName);
	public void saveUser(Employee user);
	public List<Employee> findAll();
	public Employee findById(int id);
	public Long deleteById(int id);
}
