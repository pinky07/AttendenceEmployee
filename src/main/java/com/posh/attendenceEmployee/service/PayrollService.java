package com.posh.attendenceEmployee.service;
import java.util.List;

import javax.transaction.Transactional;

import com.posh.attendenceEmployee.model.Payroll;

public interface PayrollService {

	public Payroll savePayroll(Payroll payroll);
	public Payroll findByEmployeeid(String name);
	public Payroll findById(int id);
	public List<Payroll> findAll();
	@Transactional
    Long deleteById(int id);
	
}
