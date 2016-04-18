package com.me.finalproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="personID")

public class User extends Person{
	@Column(name="username",unique=true, nullable=false)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="catcode",nullable=false)
	private String category;
	public User(){
	}
	
	public User(String username, String password, String category) {
		this.username = username;
		this.password = password;
		this.category = category;
	}

	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}