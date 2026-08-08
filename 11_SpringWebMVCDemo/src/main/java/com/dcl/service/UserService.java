package com.dcl.service;

import java.util.List;

import com.dcl.entity.User;

public interface UserService {

	User addUser(User u);
	
	void updateUser(User u);
	
	void deleteUser(Integer userId);
	
	User getById(Integer userId);
	
	List<User> findAll();
}
