package com.cmcoding.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/users/{id}", produces = "application/json")
	public UserEntity getUser(@PathVariable("id") Long userId) {
		System.out.println("Got id: " + userId);
		UserEntity user = userRepository.findById(userId).get();
		System.out.println("Found userEntity: " + user);
		return user;
	}
}
