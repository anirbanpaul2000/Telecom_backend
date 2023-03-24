package com.stl.telecom.web.application.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name="teleuser")
public class TeleUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name="userMail")
	private String userMail;
	@Column(name="contactNumber")
	private String contactNumber;
	@Column(name="password")
	private String password;
	@Column(name="address")
	private String address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public TeleUser(long id, String name, String userMail, String contactNumber, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.userMail = userMail;
		this.contactNumber = contactNumber;
		this.password = password;
		this.address = address;
	}
	public TeleUser() {
		super();
	}
	

}
