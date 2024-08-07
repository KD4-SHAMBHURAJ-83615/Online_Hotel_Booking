package com.hotelhub.entity;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel extends Base {

	@Column(name="hotel_name" , nullable = false,length = 50)
	private String hotelName;
	
	@Column(name="contact_details" , nullable = false,length = 20)
	private String contactDetails;
	
	@Column(name="image" )
	private byte[] image;
	
	private boolean swimmingPool;
	
	private boolean restaurant;
	
	private boolean gym;
	
	private boolean parking;
	
	private boolean wifi;
	
	private boolean powerbackup;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;

	
	
	

}
