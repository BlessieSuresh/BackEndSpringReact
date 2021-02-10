package com.tp.cipoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cipoll")
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public UserEntity addUser(@RequestBody UserEntity user1){
		return service.addUser(user1);
	}
	
	@PutMapping("/updateUser")
	public UserEntity update(@RequestBody UserEntity user1){
		return service.updateUser(user1);
	}
	
	@GetMapping("/getUser/{id}")
	public UserEntity get(@PathVariable Long id){
		return service.get(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void delete(@PathVariable Long id){
		service.delete(id);
	}
	
}
