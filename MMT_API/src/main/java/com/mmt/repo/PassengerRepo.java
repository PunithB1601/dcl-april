package com.mmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.entity.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Integer>{

}
