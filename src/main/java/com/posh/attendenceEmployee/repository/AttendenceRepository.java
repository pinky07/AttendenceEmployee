package com.posh.attendenceEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posh.attendenceEmployee.model.Attendence;
@Repository("attendenceRepository")
public interface AttendenceRepository extends JpaRepository<Attendence,Long>{
	Attendence findByEmployee (int employeeId );
}
