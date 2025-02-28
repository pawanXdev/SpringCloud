package com.ps.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.main.entities.User;
import com.ps.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user)
	{
	
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() 
	{
				
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserDetails(int id)
	{
		
		return userRepository.findById(id);
	}

	@Override
	public User updateUserDetails(int id, User newUser)
	{
	User userData =	userRepository.findById(id).orElse(null);
	
	if (userData != null)
	{
		
		return userRepository.save(newUser);
	}
	else
	{
		 throw new RuntimeException("User not found with id : "+id);
	}
		
	}

	@Override
	public void deleteUser(int id) 
	{
	
		userRepository.deleteById(id);
	}

}
