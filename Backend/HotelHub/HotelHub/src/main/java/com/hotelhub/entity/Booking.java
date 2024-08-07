package com.hotelhub.entity;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking extends Base {
	
	@Column(name="cheak_in" )
	private LocalDate cheakIn;
	
	@Column(name="cheak_out" )
	private LocalDate cheakOut;
	
	@Column(name="total_rent" )
	private double totalRent;
	
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;


	
	
}
