package com.posh.attendenceEmployee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posh.attendenceEmployee.model.Employee;
import com.posh.attendenceEmployee.model.Profile;
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	Employee findByUserName(String email);
	public List<Employee> findAll();
	public Employee findById(int id);
	@Transactional
    Long deleteById(int id);
	
}
