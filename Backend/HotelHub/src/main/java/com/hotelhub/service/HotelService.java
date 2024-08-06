package com.hotelhub.service;


import com.hotelhub.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    List<HotelDTO> getAllHotels();
    HotelDTO getHotelById(Long id);
    //List<HotelDTO> searchHotels(String location, String amenities);
    public List<HotelDTO> searchHotels(String hotelName) ;
}

