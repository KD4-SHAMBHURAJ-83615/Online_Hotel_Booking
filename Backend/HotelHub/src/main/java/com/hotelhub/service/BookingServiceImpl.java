package com.hotelhub.service;



import com.hotelhub.dao.BookingDao;
import com.hotelhub.dao.HotelDao;
import com.hotelhub.dao.RoomDao;
import com.hotelhub.dao.UserDao;
import com.hotelhub.dto.BookingDTO;
import com.hotelhub.entity.Booking;
import com.hotelhub.entity.Hotel;
import com.hotelhub.entity.Room;
import com.hotelhub.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingRepository;

    @Autowired
    private HotelDao hotelRepository;

    @Autowired
    private RoomDao roomRepository;

    @Autowired
    private UserDao userRepository;


    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setCheakIn(bookingDTO.getCheckIn());
        booking.setCheakOut(bookingDTO.getCheckOut());
        booking.setTotalRent(bookingDTO.getTotalRent());

        Hotel hotel = hotelRepository.findById(bookingDTO.getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        Room room = roomRepository.findById(bookingDTO.getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepository.findById(bookingDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        booking.setHotel(hotel);
        booking.setRoom(room);
        booking.setUser(user);

        Booking savedBooking = bookingRepository.save(booking);
        return convertToDTO(savedBooking);
    }

    private BookingDTO convertToDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setCheckIn(booking.getCheakIn());
        dto.setCheckOut(booking.getCheakOut());
        dto.setTotalRent(booking.getTotalRent());
        dto.setId(booking.getHotel().getId());
        dto.setId(booking.getRoom().getId());
        dto.setId(booking.getUser().getId());
        return dto;
    }
}

