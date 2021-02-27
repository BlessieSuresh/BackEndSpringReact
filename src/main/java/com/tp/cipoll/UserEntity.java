package com.tp.cipoll;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
//testing socketxp again
//socketxp with jenkins

@Entity
@Data
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Setter(value = AccessLevel.NONE)
	private Long id;
	
	private String name;
	
	private String username;
	
	private String password;

}
