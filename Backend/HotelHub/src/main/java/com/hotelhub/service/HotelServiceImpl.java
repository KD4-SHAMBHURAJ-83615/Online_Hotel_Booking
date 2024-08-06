package com.hotelhub.service;

import com.hotelhub.dao.HotelDao;
import com.hotelhub.dto.HotelDTO;
import com.hotelhub.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<HotelDTO> getAllHotels() {
        return hotelDao.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        return hotelDao.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public List<HotelDTO> searchHotels(String hotelName) {
        List<Hotel> hotels = hotelDao.findByHotelNameContainingIgnoreCase(hotelName);
        return hotels.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private HotelDTO convertToDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setId(hotel.getId());
        dto.setHotelName(hotel.getHotelName());
        dto.setContactDetails(hotel.getContactDetails());
        dto.setSwimmingPool(hotel.isSwimmingPool());
        dto.setRestaurant(hotel.isRestaurant());
        dto.setGym(hotel.isGym());
        dto.setParking(hotel.isParking());
        dto.setWifi(hotel.isWifi());
        dto.setPowerbackup(hotel.isPowerbackup());
        return dto;
    }

}
