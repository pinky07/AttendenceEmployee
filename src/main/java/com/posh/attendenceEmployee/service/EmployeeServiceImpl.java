package com.posh.attendenceEmployee.service;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.posh.attendenceEmployee.model.Employee;
import com.posh.attendenceEmployee.model.Profile;
import com.posh.attendenceEmployee.repository.EmployeeRepository;
import com.posh.attendenceEmployee.repository.ProfileRepository;




@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
    private ProfileRepository profileRepository;
	 @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 java.util.Date date=new java.util.Date();  
	@Override
	public Employee findUserByUserName(String userName) {
		return employeeRepository.findByUserName(userName);
	}

	@Override
	public void saveUser(Employee user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
//		Profile role = profileRepository.findByName("Developer");
		//user.setProfile( new HashSet<Profile> (Arrays.asList(role)));
		//user.setProfile(user.getProfile());
		user.setCreatedate(date);
		employeeRepository.save(user);
		
	}
}
