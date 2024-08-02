package com.hotelhub.entity;

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
	
	@Enumerated(EnumType.STRING)
	@Column(name="room_Status")
	private RoomStatus roomStatus;
	
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
	public enum RoomStatus{
		AVAILABLE, OCCUPIED, RESERVED

	}
	public Room() {
		
	}
	public Room(String roomNumber, RoomType roomType, RoomStatus roomStatus, boolean available, boolean tv, boolean ac,
			double rent, byte[] images, Hotel hotel) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.available = available;
		this.tv = tv;
		this.ac = ac;
		this.rent = rent;
		this.images = images;
		this.hotel = hotel;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public RoomStatus getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public byte[] getImages() {
		return images;
	}
	public void setImages(byte[] images) {
		this.images = images;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomStatus=" + roomStatus
				+ ", available=" + available + ", tv=" + tv + ", ac=" + ac + ", rent=" + rent + ", images="
				+ Arrays.toString(images) + ", hotel=" + hotel + "]";
	}
	
	

}
