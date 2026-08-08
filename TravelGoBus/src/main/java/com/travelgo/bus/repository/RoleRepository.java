package com.travelgo.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelgo.bus.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
