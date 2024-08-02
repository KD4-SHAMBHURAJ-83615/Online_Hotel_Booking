package com.hotelhub.entity;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;



@MappedSuperclass
@Getter
@Setter
@ToString
public class Base {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(name="created_on" )
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name="updated_on" )
	private LocalDate updatedOn;

}
