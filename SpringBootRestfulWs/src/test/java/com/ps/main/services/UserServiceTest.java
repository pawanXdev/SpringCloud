package com.ps.main.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ps.main.entities.User;
import com.ps.main.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;  // Inject Implementation

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setUserName("Pawan Shukla");
        user.setUserEmail("pawan@gmail.com");
        user.setPassword("pawan123");
        user.setCity("Gurugram");
    }

    @Test
    void testSaveUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertNotNull(savedUser);
        assertEquals("Pawan Shukla", savedUser.getUserName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testGetUserById() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserDetails(1);
        assertTrue(foundUser.isPresent());
        User retrievedUser = foundUser.get();
      assertEquals("Pawan Shukla" , retrievedUser.getUserName());
        assertEquals("pawan@gmail.com" , retrievedUser.getUserEmail());
     
        verify(userRepository, times(1)).findById(1);
    }
}