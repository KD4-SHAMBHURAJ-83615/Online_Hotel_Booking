package com.hotelhub.service;

import com.hotelhub.dao.AddressDao;
import com.hotelhub.dao.HotelDao;
import com.hotelhub.dao.UserDao;
import com.hotelhub.dto.HotelRequestDTO;
import com.hotelhub.dto.HotelResponseDTO;
import com.hotelhub.entity.Address;
import com.hotelhub.entity.Hotel;
import com.hotelhub.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl {

    @Autowired
    private HotelDao hotelDao; // Ensure this is the correct DAO

    @Autowired
    private UserDao userDao;   // Ensure this is the correct DAO

    @Autowired
    private AddressDao addressDao; // Ensure this is the correct DAO

    @Transactional
    public HotelResponseDTO addHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelRequestDTO.getHotelName());
        hotel.setContactDetails(hotelRequestDTO.getContactDetails());
        hotel.setImage(hotelRequestDTO.getImage());
        hotel.setSwimmingPool(hotelRequestDTO.isSwimmingPool());
        hotel.setRestaurant(hotelRequestDTO.isRestaurant());
        hotel.setGym(hotelRequestDTO.isGym());
        hotel.setParking(hotelRequestDTO.isParking());
        hotel.setWifi(hotelRequestDTO.isWifi());
        hotel.setPowerbackup(hotelRequestDTO.isPowerbackup());

        Optional<User> userOptional = userDao.findById(hotelRequestDTO.getUserId());
        Optional<Address> addressOptional = addressDao.findById(hotelRequestDTO.getAddressId());

        if (userOptional.isPresent() && addressOptional.isPresent()) {
            hotel.setUser(userOptional.get());
            hotel.setAddress(addressOptional.get());
            hotel = hotelDao.save(hotel);
            return convertToResponseDTO(hotel);
        } else {
            throw new RuntimeException("User or Address not found");
        }
    }

    @Transactional
    public void deleteHotel(Long id) {
        if (hotelDao.existsById(id)) {
            hotelDao.deleteById(id);
        } else {
            throw new RuntimeException("Hotel not found");
        }
    }

    @Transactional
    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO) {
        Optional<Hotel> hotelOptional = hotelDao.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotel.setHotelName(hotelRequestDTO.getHotelName());
            hotel.setContactDetails(hotelRequestDTO.getContactDetails());
            hotel.setImage(hotelRequestDTO.getImage());
            hotel.setSwimmingPool(hotelRequestDTO.isSwimmingPool());
            hotel.setRestaurant(hotelRequestDTO.isRestaurant());
            hotel.setGym(hotelRequestDTO.isGym());
            hotel.setParking(hotelRequestDTO.isParking());
            hotel.setWifi(hotelRequestDTO.isWifi());
            hotel.setPowerbackup(hotelRequestDTO.isPowerbackup());

            Optional<User> userOptional = userDao.findById(hotelRequestDTO.getUserId());
            Optional<Address> addressOptional = addressDao.findById(hotelRequestDTO.getAddressId());

            if (userOptional.isPresent() && addressOptional.isPresent()) {
                hotel.setUser(userOptional.get());
                hotel.setAddress(addressOptional.get());
                hotel = hotelDao.save(hotel);
                return convertToResponseDTO(hotel);
            } else {
                throw new RuntimeException("User or Address not found");
            }
        } else {
            throw new RuntimeException("Hotel not found");
        }
    }
    
    @Transactional(readOnly = true)
    public List<HotelResponseDTO> getAllHotels() {
        List<Hotel> hotels = hotelDao.findAll();
        return hotels.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    private HotelResponseDTO convertToResponseDTO(Hotel hotel) {
        HotelResponseDTO hotelResponseDTO = new HotelResponseDTO();
        hotelResponseDTO.setId(hotel.getId());
        hotelResponseDTO.setHotelName(hotel.getHotelName());
        hotelResponseDTO.setContactDetails(hotel.getContactDetails());
        hotelResponseDTO.setImage(hotel.getImage());
        hotelResponseDTO.setSwimmingPool(hotel.isSwimmingPool());
        hotelResponseDTO.setRestaurant(hotel.isRestaurant());
        hotelResponseDTO.setGym(hotel.isGym());
        hotelResponseDTO.setParking(hotel.isParking());
        hotelResponseDTO.setWifi(hotel.isWifi());
        hotelResponseDTO.setPowerbackup(hotel.isPowerbackup());
        hotelResponseDTO.setUserId(hotel.getUser().getId());
        hotelResponseDTO.setAddressId(hotel.getAddress().getId());
        return hotelResponseDTO;
    }
}


