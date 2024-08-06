package com.hotelhub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelhub.entity.Booking;

public interface BookingDao  extends JpaRepository<Booking, Long> {
    // Custom query methods can be defined here if needed
}
