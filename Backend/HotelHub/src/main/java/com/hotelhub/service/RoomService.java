package com.hotelhub.service;



import com.hotelhub.dto.RoomDTO;
import com.hotelhub.entity.Room;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAvailableRooms(Long hotelId);
    RoomDTO getRoomById(Long id);
    public Room addRoom(RoomDTO roomDTO);
    public Room updateRoom(Long id, RoomDTO roomDTO);
    public void deleteRoom(Long id) ;
    public List<Room> getAllRooms();
	List<RoomDTO> getAllRoomsByHotelId(Long hotelId);
	// Ensure this method exists in roomService
	public RoomDTO convertToDTO(Room room) ;

}
