package com.hotelhub.dao;

import com.hotelhub.entity.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room, Long> {
	List<Room> findByHotelIdAndAvailableTrue(Long hotelId);

	List<Room> findByHotelId(Long hotelId);
}
