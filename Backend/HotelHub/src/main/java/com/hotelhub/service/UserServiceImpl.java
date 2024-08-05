package com.hotelhub.service;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelhub.custom_exceptions.AuthenticationException;
import com.hotelhub.dao.UserDao;
import com.hotelhub.dao.AddressDao;
import com.hotelhub.dto.AuthRequest;
import com.hotelhub.dto.UserRegisterDTO;
import com.hotelhub.dto.UserRespDTO;
import com.hotelhub.entity.User;
import com.hotelhub.entity.Address;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserRespDTO authenticateUser(AuthRequest dto) {
        User user = userDao.findByEmail(dto.getEmail())
                .orElseThrow(() -> new AuthenticationException("Invalid Email or Password !!!!!!"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid Email or Password !!!!!!");
        }

        return mapper.map(user, UserRespDTO.class);
    }

    @Override
    public void registerUser(UserRegisterDTO dto) {
        if (userDao.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists with this email");
        }

        User user = mapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Set.of(dto.getRole())); // Adjust based on DTO role handling
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        if (dto.getAddress() != null) {
            Address address = mapper.map(dto.getAddress(), Address.class);
            addressDao.save(address);
            user.setAddress(address);
        }

        userDao.save(user);
    }


}
