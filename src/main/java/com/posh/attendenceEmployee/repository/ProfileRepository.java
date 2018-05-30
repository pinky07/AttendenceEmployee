package com.posh.attendenceEmployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posh.attendenceEmployee.model.Profile;


@Repository("profileRepository")
public interface ProfileRepository extends JpaRepository<Profile,Long>{
	Profile findByName(String name);
	public Profile findById(int id);
	public List<Profile> findAll();
	
}
