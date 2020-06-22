package com.core.saumya.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class RegistrationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@NotEmpty(message = "Can't be blank")
	private String userName;
	@Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
	private String passWord;
	@NotBlank(message = "Email is mandatory")
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	private Address address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
