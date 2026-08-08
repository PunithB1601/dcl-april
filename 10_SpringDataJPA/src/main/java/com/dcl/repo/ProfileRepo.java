package com.dcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcl.entity.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Integer>{

}
