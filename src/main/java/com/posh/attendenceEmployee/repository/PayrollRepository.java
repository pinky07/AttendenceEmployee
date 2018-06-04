package com.posh.attendenceEmployee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posh.attendenceEmployee.model.Payroll;




@Repository("payrollRepository")
public interface PayrollRepository extends JpaRepository<Payroll,Long>{
	Payroll findByEmployeeid(String name);
	public Payroll findById(int id);
	public List<Payroll> findAll();
	@Transactional
    Long deleteById(int id);
	
	
}
