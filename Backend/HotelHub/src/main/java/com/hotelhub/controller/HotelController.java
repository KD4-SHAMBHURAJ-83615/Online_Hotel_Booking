package com.hotelhub.controller;

import com.hotelhub.dto.HotelRequestDTO;
import com.hotelhub.dto.HotelResponseDTO;
import com.hotelhub.service.HotelServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping
    public ResponseEntity<HotelResponseDTO> addHotel(@RequestBody HotelRequestDTO hotelRequestDTO) {
        HotelResponseDTO createdHotel = hotelService.addHotel(hotelRequestDTO);
        return ResponseEntity.ok(createdHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> updateHotel(@PathVariable Long id, @RequestBody HotelRequestDTO hotelRequestDTO) {
        HotelResponseDTO updatedHotel = hotelService.updateHotel(id, hotelRequestDTO);
        return ResponseEntity.ok(updatedHotel);
    }
}
