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
	
	
}
