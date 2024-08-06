package com.hotelhub.dto;


import lombok.Data;

@Data
public class HotelDTO {
    private Long id;
    private String hotelName;
    private String contactDetails;
    private byte[] image;
    private boolean swimmingPool;
    private boolean restaurant;
    private boolean gym;
    private boolean parking;
    private boolean wifi;
    private boolean powerbackup;
    private AddressDTO address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public boolean isRestaurant() {
		return restaurant;
	}
	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}
	public boolean isGym() {
		return gym;
	}
	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isPowerbackup() {
		return powerbackup;
	}
	public void setPowerbackup(boolean powerbackup) {
		this.powerbackup = powerbackup;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
    
    
}
