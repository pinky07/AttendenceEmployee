package com.posh.attendenceEmployee.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posh.attendenceEmployee.model.Payroll;
import com.posh.attendenceEmployee.repository.PayrollRepository;



@Service("PayrollService")
public class PayrollServiceImpl implements PayrollService{
	@Autowired
	private PayrollRepository payrollRepository;

	

	@Override
	public Payroll savePayroll(Payroll Payroll) {
		return payrollRepository.save(Payroll);
		
	}



	@Override
	public Payroll findByEmployeeid(String name) {
		return  payrollRepository.findByEmployeeid(name);
	} 



	@Override
	public Payroll findById(int id) {
		// TODO Auto-generated method stub
		return payrollRepository.findById(id);
	}



	@Override
	public List<Payroll> findAll() {
		// TODO Auto-generated method stub
		return payrollRepository.findAll();
	}



	@Override
	public Long deleteById(int id) {
		// TODO Auto-generated method stub
		return payrollRepository.deleteById(id);
	}

}
