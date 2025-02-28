package com.ps.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;

//import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


//import com.ps.main.entities.User;
import com.ps.main.services.UserService;


//@WebMvcTest(MyController.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    
     
    @Test
    public void testCreateUSer() throws Exception {
    	String userJson = "{\"userName\":\"Pawan Shukla\",\"userCity\":\"Gurugram\"}";
    	
		
         	mockMvc.perform(post("/user")
    		.contentType(MediaType.APPLICATION_JSON)
    		.content(userJson))
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$.id").exists())
    	.andExpect(jsonPath("$.userName").value("Pawan Shukla"))
    	.andExpect(jsonPath("$.userCity").value("Gurugram"));
    			
    			
    }
}
    			
    			
    			
    			
    			


