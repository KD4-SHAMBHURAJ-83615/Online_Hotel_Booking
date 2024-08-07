package com.hotelhub.entity;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review extends Base{
	
	@Column(name="comment" )
	private String comment;
	
	@Column(name="rating" )
	private double rating;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	public Review() {
		
	}

	public Review(long id, LocalDate createdOn, LocalDate updatedOn) {
		super(id, createdOn, updatedOn);
		// TODO Auto-generated constructor stub
	}

	public Review(String comment, double rating, User user, Hotel hotel) {
		super();
		this.comment = comment;
		this.rating = rating;
		this.user = user;
		this.hotel = hotel;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Review [comment=" + comment + ", rating=" + rating + ", user=" + user + ", hotel=" + hotel + "]";
	}
	
	

	
}
