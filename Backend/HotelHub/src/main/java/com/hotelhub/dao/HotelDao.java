package com.hotelhub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelhub.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long> {

}
