package com.tp.cipoll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void testRepository() {
		UserEntity user1 = new UserEntity();
		user1.setName("Tim");
		user1.setUsername("Timmy");
		user1.setPassword("Timmypasswd");
		
		repository.save(user1);
		assertEquals(1, repository.findAll().size());
		
		UserEntity loadedUser = repository.findById(user1.getId()).get();
		assertEquals("Tim", loadedUser.getName());
		assertEquals("Timmy", loadedUser.getUsername());
		assertEquals("Timmypasswd", loadedUser.getPassword());
		
	}
}
