package com.hotelhub.entity;

import java.time.LocalDate;

import javax.persistence.*;


import lombok.*;



@MappedSuperclass
@Getter
@Setter
@ToString
public class Base {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="created_on" )
	private LocalDate createdOn;
	
	@Column(name="updated_on" )
	private LocalDate updatedOn;

}
