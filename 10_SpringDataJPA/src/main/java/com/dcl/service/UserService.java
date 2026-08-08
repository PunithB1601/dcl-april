package com.dcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.entity.Profile;
import com.dcl.entity.User;
import com.dcl.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private ProfileService pservice;
	
	@Transactional
	public User saveUser(User u,Profile p) {
		u=urepo.save(u);
	//	int a=10/0;
		p=pservice.saveProfile(p);
		return u;
	}
}
