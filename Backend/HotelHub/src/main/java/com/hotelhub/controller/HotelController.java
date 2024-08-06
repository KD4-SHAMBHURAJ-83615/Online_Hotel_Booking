package com.hotelhub.controller;




	import com.hotelhub.dto.HotelDTO;
	import com.hotelhub.service.HotelService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/hotels")
	public class HotelController {

	    @Autowired
	    private HotelService hotelService;

	    @GetMapping
	    public List<HotelDTO> getAllHotels() {
	        return hotelService.getAllHotels();
	    }

	    @GetMapping("/{id}")
	    public HotelDTO getHotelById(@PathVariable Long id) {
	        return hotelService.getHotelById(id);
	    }

	    @GetMapping("/search")
	    public List<HotelDTO> searchHotels(@RequestParam String hotelName) {
	        return hotelService.searchHotels(hotelName);
	    }
	    
	    
	}


