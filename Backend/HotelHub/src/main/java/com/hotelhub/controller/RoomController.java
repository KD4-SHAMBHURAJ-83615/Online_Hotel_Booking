package com.hotelhub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelhub.dto.RoomDTO;
import com.hotelhub.entity.Room;
import com.hotelhub.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDTO> addRoom(@RequestBody RoomDTO roomDTO) {
        Room room = roomService.addRoom(roomDTO);
        return new ResponseEntity<>(roomService.getRoomById(room.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        Room room = roomService.updateRoom(id, roomDTO);
        return new ResponseEntity<>(roomService.getRoomById(room.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        List<RoomDTO> rooms = roomService.getAllRooms().stream()
                .map(roomService::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        RoomDTO roomDTO = roomService.getRoomById(id);
        return roomDTO != null ? new ResponseEntity<>(roomDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(@RequestParam Long hotelId) {
        List<RoomDTO> rooms = roomService.getAvailableRooms(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<RoomDTO>> getAllRoomsByHotelId(@RequestParam Long hotelId) {
        List<RoomDTO> rooms = roomService.getAllRoomsByHotelId(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
