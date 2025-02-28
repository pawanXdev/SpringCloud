package com.ps.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.main.entities.User;
import com.ps.main.services.UserService;


@RestController

@ResponseBody
public class MyController
{
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
  public ResponseEntity<User>createUser(@RequestBody User user)
	{
		User createdUser = userService.createUser(user);
		return ResponseEntity.ok(createdUser);
	}
	
	@GetMapping("/user")
	
	public List<User> getAllUserDetails()
			
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable int id)
	
	{
	User user =	userService.getUserDetails(id).orElse(null);
	if(user != null)
	{
		return ResponseEntity.ok().body(user);
	}
	else
	{
        return ResponseEntity.notFound().build();	
				}
    }
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user)
	{
User updatedUser =	userService.updateUserDetails(id, user);
    if(updatedUser != null)
{
	return ResponseEntity.ok(updatedUser);
}
    else
    {
        return ResponseEntity.notFound().build();
    }
}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}