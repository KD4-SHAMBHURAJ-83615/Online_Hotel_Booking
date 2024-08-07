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


	public Booking() {
		
	}


	public Booking(LocalDate cheakIn, LocalDate cheakOut, double totalRent, Hotel hotel, Room room, User user) {
		super();
		this.cheakIn = cheakIn;
		this.cheakOut = cheakOut;
		this.totalRent = totalRent;
		this.hotel = hotel;
		this.room = room;
		this.user = user;
	}


	public LocalDate getCheakIn() {
		return cheakIn;
	}


	public void setCheakIn(LocalDate cheakIn) {
		this.cheakIn = cheakIn;
	}


	public LocalDate getCheakOut() {
		return cheakOut;
	}


	public void setCheakOut(LocalDate cheakOut) {
		this.cheakOut = cheakOut;
	}


	public double getTotalRent() {
		return totalRent;
	}


	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Booking [cheakIn=" + cheakIn + ", cheakOut=" + cheakOut + ", totalRent=" + totalRent + ", hotel="
				+ hotel + ", room=" + room + ", user=" + user + "]";
	}
	
	
}
