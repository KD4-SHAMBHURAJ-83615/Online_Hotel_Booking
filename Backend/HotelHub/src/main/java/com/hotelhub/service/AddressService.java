package com.hotelhub.service;

import com.hotelhub.dao.AddressDao;
import com.hotelhub.dao.UserDao;
import com.hotelhub.dto.AddressDTO;
import com.hotelhub.entity.Address;
import com.hotelhub.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper mapper;

    public void saveAddress(AddressDTO addressDTO) {
        User user = userDao.findById(addressDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = mapper.map(addressDTO, Address.class);
        address.setUser(user);

        addressDao.save(address);
    }
}
