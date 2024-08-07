package com.hotelhub.controller;

import com.hotelhub.dto.HotelRequestDTO;
import com.hotelhub.dto.HotelResponseDTO;
import com.hotelhub.service.HotelServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;
    
    @GetMapping
    public List<HotelResponseDTO> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public ResponseEntity<HotelResponseDTO> addHotel(@RequestBody HotelRequestDTO hotelRequestDTO) {
        HotelResponseDTO createdHotel = hotelService.addHotel(hotelRequestDTO);
        return ResponseEntity.ok(createdHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        try {
            hotelService.deleteHotel(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> updateHotel(@PathVariable Long id, @RequestBody HotelRequestDTO hotelRequestDTO) {
        try {
            HotelResponseDTO updatedHotel = hotelService.updateHotel(id, hotelRequestDTO);
            return ResponseEntity.ok(updatedHotel);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/name/{hotelName}")
    public List<HotelResponseDTO> getHotelsByName(@PathVariable String hotelName) {
        return hotelService.getHotelsByName(hotelName);
    }

    @GetMapping("/address")
    public List<HotelResponseDTO> getHotelsByAddress(@RequestParam String city, @RequestParam String state) {
        return hotelService.getHotelsByAddress(city, state);
    }
}

