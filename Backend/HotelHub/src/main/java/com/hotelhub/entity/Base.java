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
	private long id;
	
	@CreationTimestamp
	@Column(name="created_on" )
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name="updated_on" )
	private LocalDate updatedOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Base() {
		
	}

	public Base(long id, LocalDate createdOn, LocalDate updatedOn) {
		super();
		this.id = id;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Base [id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	

	
}
