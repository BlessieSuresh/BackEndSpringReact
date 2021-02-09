package com.tp.cipoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserEntity addUser(UserEntity user){
		return this.repository.save(user);
	}
	
	public UserEntity updateUser(UserEntity user1){
		return this.repository.save(user1);
	}
	
	public UserEntity get(Long id){
		return this.repository.findById(id).orElse(null);
	}
	
	public void delete(Long id){
		this.repository.deleteById(id);
	}

}
