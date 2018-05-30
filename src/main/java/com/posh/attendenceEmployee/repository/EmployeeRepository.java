package com.posh.attendenceEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posh.attendenceEmployee.model.Employee;
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	Employee findByUserName(String email);
}
