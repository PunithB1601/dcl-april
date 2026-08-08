package com.travelgo.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelgo.bus.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
