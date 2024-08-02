package com.hotelhub.dto;


import com.hotelhub.entity.Room.RoomStatus;
import com.hotelhub.entity.Room.RoomType;
import lombok.Data;

@Data
public class RoomRequestDTO {

    private String roomNumber;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private boolean available;
    private boolean tv;
    private boolean ac;
    private double rent;
    private byte[] images;
    private Long hotelId; // Foreign key reference
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
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
    
    
}

