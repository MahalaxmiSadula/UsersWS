package com.ms.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestModel {

	@NotNull(message="username required")
	@Size(min=2, message =" username should be atleast two characters")
	private String username;

	@NotNull(message="password required")
	@Size(min=8, max=16, message =" password should be atleast two characters")
	private String password;
	
	@NotNull(message="password required")
	@Email
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
