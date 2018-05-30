package com.posh.attendenceEmployee.service;

import com.posh.attendenceEmployee.model.Attendence;

public interface AttendenceService {

	Attendence findByEmployee (int employeeId );
	public void saveAttendence(Attendence user);
	
}
