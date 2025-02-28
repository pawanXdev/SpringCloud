package com.ps.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ps.main.entities.User;

@Service
public interface UserService 
{
   public User createUser(User user);
   
   public List<User>  getAllUsers();
   public Optional<User> getUserDetails(int id);
   
   public User updateUserDetails(int id, User user);
   public void deleteUser(int id);
}
  