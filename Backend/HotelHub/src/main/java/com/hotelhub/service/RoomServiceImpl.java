package com.hotelhub.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelhub.dao.HotelDao;
import com.hotelhub.dao.RoomDao;
import com.hotelhub.dto.RoomDTO;
import com.hotelhub.entity.Hotel;
import com.hotelhub.entity.Room;

@Transactional
@Service
public class RoomServiceImpl implements RoomService{

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
        Hotel hotel = hotelDao.findById(roomDTO.getHotelId())
                            .orElseThrow(() -> new RuntimeException("Hotel not found"));
        room.setHotel(hotel);
        return roomDao.save(room);
    }

    @Transactional
    public Room updateRoom(Long id, RoomDTO roomDTO) {
        Room room = roomDao.findById(id)
                            .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setRoomType(roomDTO.getRoomType());
        room.setRoomStatus(roomDTO.getRoomStatus());
        room.setAvailable(roomDTO.isAvailable());
        room.setTv(roomDTO.isTv());
        room.setAc(roomDTO.isAc());
        room.setRent(roomDTO.getRent());
        room.setImages(roomDTO.getImages());
        Hotel hotel = hotelDao.findById(roomDTO.getHotelId())
                            .orElseThrow(() -> new RuntimeException("Hotel not found"));
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
    
    @Override
    public List<RoomDTO> getAvailableRooms(Long hotelId) {
        return roomDao.findByHotelIdAndAvailableTrue(hotelId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        return roomDao.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public RoomDTO convertToDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomType(room.getRoomType());
        dto.setRoomStatus(room.getRoomStatus());
        dto.setAvailable(room.isAvailable());
        dto.setTv(room.isTv());
        dto.setAc(room.isAc());
        dto.setRent(room.getRent());
        dto.setImages(room.getImages());
        dto.setHotelId(room.getHotel().getId()); // Assuming `Hotel` is always set
        return dto;
    }
    
    @Override
    public List<RoomDTO> getAllRoomsByHotelId(Long hotelId) {
        List<Room> rooms = roomDao.findByHotelId(hotelId);
        return rooms.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
