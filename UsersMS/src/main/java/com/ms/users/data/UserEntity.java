package com.ms.users.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myusers")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275932366468338736L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="username",nullable=false, length=50)
	private String username;

	@Column(name="email",nullable=false, length=120)
	private String email;

	@Column(name="userId",nullable=false, unique=true)
	private String userId;

	@Column(name="encryptedPassword",nullable=false, unique=true)
	private String encryptedPassword;
	// JPA demands empty constructor
//	public UserEntity() {}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
}
