package com.hotelhub.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalRent;
    private HotelDTO hotel;
    private RoomDTO room;
    private UserDTO user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	public double getTotalRent() {
		return totalRent;
	}
	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}
	public HotelDTO getHotel() {
		return hotel;
	}
	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}
	public RoomDTO getRoom() {
		return room;
	}
	public void setRoom(RoomDTO room) {
		this.room = room;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
    
    
}

