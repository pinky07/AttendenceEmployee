package com.posh.attendenceEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posh.attendenceEmployee.model.Holiday;
import com.posh.attendenceEmployee.repository.HolidayRepository;

@Service("holidayService")
public class HolidayServiceImpl implements HolidayService {
	@Autowired 
	public HolidayRepository holidayRepository;

	@Override
	public Holiday saveHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		return  holidayRepository.save(holiday);
	}

	@Override
	public Holiday findByName(String name) {
		// TODO Auto-generated method stub
		return holidayRepository.findByName(name);
	}

	@Override
	public Holiday findById(int id) {
		// TODO Auto-generated method stub
		return holidayRepository.findById(id);
	}

	@Override
	public List<Holiday> findAll() {
		// TODO Auto-generated method stub
		return holidayRepository.findAll();
	}

	@Override
	public Long deleteById(int id) {
		// TODO Auto-generated method stub
		return holidayRepository.deleteById(id);
	}

}
