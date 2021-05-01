package com.cg.onlineadvapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NotBlank(message="name cannot be left empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message="User name should only contain alphabets")
	private String name;
	@NotBlank(message="Login name cannot be left blank")
	@Column(unique=true)
	private String loginName;
	@Size(min = 8, max = 33, message = "Password should be greater than 7 and less than 13 characters")
	private String password;
	@Size(min = 8, max = 33, message = "Password should be greater than 7 and less than 13 characters")
	private String confirmPassword;
	@Size(min = 10, max = 10, message="Contact number should consist 10 digits")
	@Pattern(regexp= "[0-9]+", message="Contact number should only contain numeric value")
	private String contactNo;
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Email is Incorrect")
	private String email;
	@Column(updatable = false)
	private Integer role = 2;
	@Embedded
	private Address address;
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="user_id" ,referencedColumnName = "userId")
	private List<Advertise> advertise=new ArrayList<>();
	
	public User() {
		super();
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}