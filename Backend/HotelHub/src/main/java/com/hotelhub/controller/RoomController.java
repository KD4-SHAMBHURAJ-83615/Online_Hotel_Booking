package com.hotelhub.controller;

import com.hotelhub.dto.RoomDTO;
import com.hotelhub.entity.Room;
import com.hotelhub.service.RoomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

      
    
    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody RoomDTO roomDTO) {
        Room room = roomService.addRoom(roomDTO);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        Room room = roomService.updateRoom(id, roomDTO);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    
}
