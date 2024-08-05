package com.hotelhub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotelhub.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long> {

	@Query("SELECT h FROM Hotel h WHERE h.hotelName = :hotelName")
    List<Hotel> findByHotelName(@Param("hotelName") String hotelName);

    @Query("SELECT h FROM Hotel h WHERE h.address.city = :city AND h.address.state = :state")
    List<Hotel> findByAddress(@Param("city") String city, @Param("state") String state);
}
