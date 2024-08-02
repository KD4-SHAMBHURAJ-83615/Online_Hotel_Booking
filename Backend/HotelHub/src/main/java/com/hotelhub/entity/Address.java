package com.hotelhub.entity;
//import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;



@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address extends Base{
	
	@Column(name="address_line" , nullable = false)
	private String addressLine;
	
	@Column(name="city" ,length = 50)
	private String city;
	
	@Column(name="pincode",length = 10 )
	private int pincode;
	
	@Column(name="state" ,length = 50)
	private String state;
	
	
	@Column(name="country",length = 50 )
	private String country;


	public Address() {
		
	}


	public Address(String addressLine, String city, int pincode, String state, String country) {
		super();
		this.addressLine = addressLine;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}


	public String getAddressLine() {
		return addressLine;
	}


	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + ", pincode=" + pincode + ", state=" + state
				+ ", country=" + country + "]";
	}

	
	
	

}
