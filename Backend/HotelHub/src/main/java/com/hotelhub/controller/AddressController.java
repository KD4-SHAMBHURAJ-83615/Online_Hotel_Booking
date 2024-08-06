package com.hotelhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hotelhub.custom_exception.ResourceNotFoundException;
import com.hotelhub.dto.AddressDTO;

import com.hotelhub.service.AddressServiceImpl;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable(value = "id") Long id) {
        AddressDTO address = addressService.getAddressById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + id));
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.saveAddress(addressDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable(value = "id") Long id, @RequestBody AddressDTO addressDetails) {
        AddressDTO updatedAddress = addressService.updateAddress(id, addressDetails);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable(value = "id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
