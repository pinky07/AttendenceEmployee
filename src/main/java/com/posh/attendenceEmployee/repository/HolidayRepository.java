package com.posh.attendenceEmployee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posh.attendenceEmployee.model.Holiday;

@Repository("holidayRepository")
public interface HolidayRepository extends JpaRepository<Holiday,Long>{
	Holiday findByName(String name);
	public Holiday findById(int id);
	public List<Holiday> findAll();
//	public void save(Holiday holiday);
	@Transactional
    Long deleteById(int id);
}
