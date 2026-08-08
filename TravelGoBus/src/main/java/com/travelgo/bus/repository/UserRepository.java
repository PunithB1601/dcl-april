package com.travelgo.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelgo.bus.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
