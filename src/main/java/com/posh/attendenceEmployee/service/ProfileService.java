package com.posh.attendenceEmployee.service;
import java.util.List;

import javax.transaction.Transactional;

import com.posh.attendenceEmployee.model.Profile;

public interface ProfileService {

	public Profile saveProfile(Profile profile);
	public Profile findByName(String name);
	public Profile findById(int id);
	public List<Profile> findAll();
	@Transactional
    Long deleteById(int id);
	
}
