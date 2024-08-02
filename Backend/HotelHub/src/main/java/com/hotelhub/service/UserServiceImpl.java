package com.hotelhub.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelhub.custom_exceptions.AuthenticationException;
import com.hotelhub.dao.UserDao;
import com.hotelhub.dto.AuthRequest;
import com.hotelhub.dto.UserRegisterDTO;
import com.hotelhub.dto.UserRespDTO;
import com.hotelhub.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder; // Correct import and annotation

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
        user.setRole(User.Role.valueOf(dto.getRole().toUpperCase()));

        userDao.save(user);
    }
}
