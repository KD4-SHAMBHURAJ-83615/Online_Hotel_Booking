package com.hotelhub.entity;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends Base {

	
	
	@Column(name="first_name" , nullable = false,length = 50)
	private String firstName;
	
	@Column(name="last_name", nullable = false,length = 50)
	private String lastname;
	
	@Column(name="email", nullable = false, unique = true,length = 50)
	private String email;
	
	@Column(name="password", nullable = false,length = 50)
	private String password;
	
	@Column(name="phone_no", nullable = false, unique = true,length = 12)
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	public enum Role{
		CUSTOMER, OWNER
	}

	public User() {
		
	}

	public User(String firstName, String lastname, String email, String password, String phoneNo, Role role) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastname=" + lastname + ", email=" + email + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", role=" + role + "]";
	}
	
	
	
}
