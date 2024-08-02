package com.hotelhub.entity;
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

	public Hotel() {
		
	}

	public Hotel(String hotelName, String contactDetails, byte[] image, boolean swimmingPool, boolean restaurant,
			boolean gym, boolean parking, boolean wifi, boolean powerbackup, User user, Address address) {
		super();
		this.hotelName = hotelName;
		this.contactDetails = contactDetails;
		this.image = image;
		this.swimmingPool = swimmingPool;
		this.restaurant = restaurant;
		this.gym = gym;
		this.parking = parking;
		this.wifi = wifi;
		this.powerbackup = powerbackup;
		this.user = user;
		this.address = address;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", contactDetails=" + contactDetails + ", image="
				+ Arrays.toString(image) + ", swimmingPool=" + swimmingPool + ", restaurant=" + restaurant + ", gym="
				+ gym + ", parking=" + parking + ", wifi=" + wifi + ", powerbackup=" + powerbackup + ", user=" + user
				+ ", address=" + address + "]";
	}
	

}
