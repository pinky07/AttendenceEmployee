package com.posh.attendenceEmployee.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.posh.attendenceEmployee.model.Attendence;
import com.posh.attendenceEmployee.model.Profile;
import com.posh.attendenceEmployee.repository.AttendenceRepository;
import com.posh.attendenceEmployee.repository.ProfileRepository;



@Service("ProfileService")
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileRepository profileRepository;

	

	@Override
	public Profile saveProfile(Profile profile) {
		return profileRepository.save(profile);
		
	}



	@Override
	public Profile findByName(String name) {
		// TODO Auto-generated method stub
		return profileRepository.findByName(name);
	}



	@Override
	public Profile findById(int id) {
		// TODO Auto-generated method stub
		return profileRepository.findById(id);
	}



	@Override
	public List<Profile> findAll() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}



	@Override
	public Long deleteById(int id) {
		// TODO Auto-generated method stub
		return profileRepository.deleteById(id);
	}

}
