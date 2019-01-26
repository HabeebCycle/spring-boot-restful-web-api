package com.cycle.habeeb.springbootrestapi.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping("users")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id- "+id);
		}
		return user;
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id- "+id);
		}
	}
	
	@PostMapping("users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createdUser = userService.save(user);
		
		//Get the new URI
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
