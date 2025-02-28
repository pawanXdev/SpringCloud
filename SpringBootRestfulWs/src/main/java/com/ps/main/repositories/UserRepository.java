package com.ps.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.main.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	




}
