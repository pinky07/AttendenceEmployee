package com.posh.attendenceEmployee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.posh.attendenceEmployee.model.Attendence;
import com.posh.attendenceEmployee.repository.AttendenceRepository;



@Service("attendenceService")
public class AttendenceServiceImpl implements AttendenceService{
	@Autowired
	private AttendenceRepository attendenceRepository;
	
	@Override
	public void saveAttendence(Attendence attendece) {
		
		attendenceRepository.save(attendece);
		
	}

	@Override
	public Attendence findByEmployee(int employeeId) {
		return attendenceRepository.findByEmployee(employeeId);
	}


}
