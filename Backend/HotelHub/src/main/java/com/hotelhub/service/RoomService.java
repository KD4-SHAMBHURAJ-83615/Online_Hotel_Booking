package com.hotelhub.service;

import com.hotelhub.dao.HotelDao;
import com.hotelhub.dao.RoomDao;
import com.hotelhub.dto.RoomDTO;
import com.hotelhub.entity.Room;
import com.hotelhub.entity.Hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private HotelDao hotelDao;

    @Transactional
    public Room addRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setRoomType(roomDTO.getRoomType());
        room.setRoomStatus(roomDTO.getRoomStatus());
        room.setAvailable(roomDTO.isAvailable());
        room.setTv(roomDTO.isTv());
        room.setAc(roomDTO.isAc());
        room.setRent(roomDTO.getRent());
        room.setImages(roomDTO.getImages());
        Hotel hotel = hotelDao.findById(roomDTO.getHotelId()).orElseThrow(() -> new RuntimeException("Hotel not found"));
        room.setHotel(hotel);
        return roomDao.save(room);
    }

    @Transactional
    public Room updateRoom(Long id, RoomDTO roomDTO) {
        Room room = roomDao.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setRoomType(roomDTO.getRoomType());
        room.setRoomStatus(roomDTO.getRoomStatus());
        room.setAvailable(roomDTO.isAvailable());
        room.setTv(roomDTO.isTv());
        room.setAc(roomDTO.isAc());
        room.setRent(roomDTO.getRent());
        room.setImages(roomDTO.getImages());
        Hotel hotel = hotelDao.findById(roomDTO.getHotelId()).orElseThrow(() -> new RuntimeException("Hotel not found"));
        room.setHotel(hotel);
        return roomDao.save(room);
    }

    @Transactional
    public void deleteRoom(Long id) {
        roomDao.deleteById(id);
    }
    
    @Transactional 
    public List<Room> getAllRooms() {
        return roomDao.findAll();
    }
}
