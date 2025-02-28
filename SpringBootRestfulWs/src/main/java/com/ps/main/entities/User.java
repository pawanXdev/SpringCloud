package com.ps.main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	
	@Column
	@JsonProperty("id")
	private int id;
	
	@Column
	@JsonProperty("userName")
	private String userName;
	
	@Column
	@JsonProperty("userEmail")
	private String userEmail;
	
	@Column
	@JsonProperty("userPassword")
	private String userPassword;
	
	@Column
	@JsonProperty("userCity")
	private String userCity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return userPassword;
	}
	public void setPassword(String password) {
		this.userPassword = password;
	}
	public String getCity() {
		return userCity;
	}
	public void setCity(String city) {
		this.userCity = city;
	}
}
	
	
	

