package com.ps.main.repositories;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ps.main.entities.User;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserRepositoryTest 
{
	
@Autowired	
private UserRepository userRepository;
@Test
public void testCreateUser() {
	
	User user = new User();
	user.setUserName("Pawan Shukla");
	user.setUserEmail("pawan@gmail.com");
	user.setPassword("pawan123");
	user.setCity("Gurugram");
	User savedUser = userRepository.save(user);
	
	
	assertNotNull(savedUser.getId());
}

//@Test
//public void testFindUserById() {
    
  //  User user = new User();
  //  user.setName("Atul Shukls");
  //  user.setEmail("atul@example.com");
   // user.setPassword("Atul123");
 //   user.setCity("Gurugram");

  //  User savedUser = userRepository.save(user);

    
  //  Optional<User> foundUser = userRepository.findById(savedUser.getId());

    // Assert
  //  assertThat(foundUser).isPresent();
  //  assertThat(foundUser.get().getName()).isEqualTo("Alice");
//}


}
	

    

