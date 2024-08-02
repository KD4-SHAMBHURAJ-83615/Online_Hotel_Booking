package com.hotelhub.entity;

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

}
