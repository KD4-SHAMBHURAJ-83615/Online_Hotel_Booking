package com.hotelhub.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name="transaction_number")
	private double transactionNumber;
	
	@Column(name = "payment_status")
	private int paymentStatus;

	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;

	@Column(name = "total_payment")
	private double totalPayment;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Payment() {
		
	}

	

	public Payment(int paymentId, double transactionNumber, int paymentStatus, LocalDate paymentDate,
			double totalPayment, Booking booking, User user) {
		super();
		this.paymentId = paymentId;
		this.transactionNumber = transactionNumber;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.totalPayment = totalPayment;
		this.booking = booking;
		this.user = user;
	}



	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(double transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", transactionNumber=" + transactionNumber + ", paymentStatus="
				+ paymentStatus + ", paymentDate=" + paymentDate + ", totalPayment=" + totalPayment + ", booking="
				+ booking + ", user=" + user + "]";
	}

	

	
	
	
}
