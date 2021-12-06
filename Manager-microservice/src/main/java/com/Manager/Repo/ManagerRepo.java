package com.Manager.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Managermicroservice.Models.ManagerInfo;

public interface ManagerRepo extends MongoRepository<ManagerInfo, String> {

	ManagerInfo findByEmail(String email);

	String getEmail();
		
	
	
}
