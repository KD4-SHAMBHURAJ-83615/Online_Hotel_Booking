package com.hotelhub.entity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room extends Base{
	
	@Column(name="room_number",length = 10 )
	private String roomNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="room_type")
	private RoomType roomType;
	
	private boolean available;
	
	private boolean tv;
	
	private boolean ac;
	
	private double rent;
	
	private byte[] images;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	
	public enum RoomType{
		SINGLE , DOUBLE ,SUITE 

	}


	
	

}
