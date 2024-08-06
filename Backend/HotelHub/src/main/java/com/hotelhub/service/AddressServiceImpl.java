package com.hotelhub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelhub.custom_exception.ResourceNotFoundException;
import com.hotelhub.dao.AddressDao;
import com.hotelhub.dto.AddressDTO;
import com.hotelhub.entity.Address;

@Service
@Transactional
public class AddressServiceImpl {

    @Autowired
    private AddressDao addressRepository;

    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AddressDTO> getAddressById(Long id) {
        return addressRepository.findById(id).map(this::convertToDTO);
    }

    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address address = convertToEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return convertToDTO(savedAddress);
    }

    public AddressDTO updateAddress(Long id, AddressDTO addressDetails) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + id));
        
        address.setAddressLine(addressDetails.getAddressLine());
        address.setCity(addressDetails.getCity());
        address.setPincode(addressDetails.getPincode());
        address.setState(addressDetails.getState());
        address.setCountry(addressDetails.getCountry());
        
        Address updatedAddress = addressRepository.save(address);
        return convertToDTO(updatedAddress);
    }

    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + id));
        addressRepository.delete(address);
    }

    private AddressDTO convertToDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setAddressLine(address.getAddressLine());
        addressDTO.setCity(address.getCity());
        addressDTO.setPincode(address.getPincode());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

    private Address convertToEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setAddressLine(addressDTO.getAddressLine());
        address.setCity(addressDTO.getCity());
        address.setPincode(addressDTO.getPincode());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        return address;
    }
}

