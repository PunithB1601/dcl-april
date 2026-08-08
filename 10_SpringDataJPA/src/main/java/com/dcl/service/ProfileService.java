package com.dcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.entity.Profile;
import com.dcl.entity.User;
import com.dcl.repo.ProfileRepo;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepo prepo;

	public Profile saveProfile(Profile p) {
		return prepo.save(p);
	}
}
