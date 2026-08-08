package com.dcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.entity.User;
import com.dcl.repo.UserRepo;
import com.dcl.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo urepo;
	
	@Override
	public User addUser(User u) {
		return urepo.save(u);
	}

	@Override
	public void updateUser(User u) {
		urepo.save(u);
	}

	@Override
	public void deleteUser(Integer userId) {
		urepo.deleteById(userId);

	}

	@Override
	public User getById(Integer userId) {
		return urepo.findById(userId).orElse(null);
	}

	@Override
	public List<User> findAll() {
		return urepo.findAll();
	}

}
