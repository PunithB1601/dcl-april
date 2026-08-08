package com.travelgo.bus.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Role {

	private Integer rollId;
	
	private String role;
	
	private String description;
	
	@OneToMany
	private List<User> users;
}
