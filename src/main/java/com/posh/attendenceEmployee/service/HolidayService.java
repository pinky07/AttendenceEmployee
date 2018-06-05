package com.posh.attendenceEmployee.service;

import java.util.List;

import javax.transaction.Transactional;

import com.posh.attendenceEmployee.model.Holiday;


public interface HolidayService {
	public Holiday saveHoliday(Holiday holiday);
	public Holiday findByName(String name);
	public Holiday findById(int id);
	public List<Holiday> findAll();
	@Transactional
    Long deleteById(int id);
}
