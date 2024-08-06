//import javax.transaction.Transactional;

//import org.springframework.stereotype.Service;

//package com.hotelhub.service;
//
//import java.util.Set;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.hotelhub.custom_exceptions.AuthenticationException;
//import com.hotelhub.dao.UserDao;
//import com.hotelhub.dao.AddressDao;
//import com.hotelhub.dto.AuthRequest;
//import com.hotelhub.dto.UserRegisterDTO;
//import com.hotelhub.dto.UserRespDTO;
//import com.hotelhub.entity.User;
//import com.hotelhub.entity.Address;
//import com.hotelhub.security.JwtUtils;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private AddressDao addressDao;
//
//    @Autowired
//    private ModelMapper mapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Override
//    public UserRespDTO authenticateUser(AuthRequest dto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        User user = userDao.findByEmail(dto.getEmail())
//                .orElseThrow(() -> new AuthenticationException("Invalid Email or Password !!!!!!"));
//
//        UserRespDTO userRespDTO = mapper.map(user, UserRespDTO.class);
//        userRespDTO.setToken(jwt);
//
//        return userRespDTO;
//    }
//
//    @Override
//    public void registerUser(UserRegisterDTO dto) {
//        if (userDao.findByEmail(dto.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("User already exists with this email");
//        }
//
//        User user = mapper.map(dto, User.class);
//        user.setPassword(passwordEncoder.encode(dto.getPassword()));
//        user.setRoles(Set.of(dto.getRole())); // Adjust based on DTO role handling
//        user.setFirstName(dto.getFirstName());
//        user.setLastName(dto.getLastName());
//
//        if (dto.getAddress() != null) {
//            Address address = mapper.map(dto.getAddress(), Address.class);
//            addressDao.save(address);
//            user.setAddress(address);
//        }
//
//        userDao.save(user);
//    }
//}

package com.hotelhub.service;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.hotelhub.security.JwtUtils;

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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public UserRespDTO authenticateUser(AuthRequest dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User user = userDao.findByEmail(dto.getEmail())
                .orElseThrow(() -> new AuthenticationException("Invalid Email or Password !!!!!!"));

        UserRespDTO userRespDTO = mapper.map(user, UserRespDTO.class);
        userRespDTO.setToken(jwt);

        // Set roles explicitly if needed
        userRespDTO.setRole(user.getRoles().stream().findFirst().orElse(null));

        return userRespDTO;
    }

    @Override
    public void registerUser(UserRegisterDTO dto) {
        if (userDao.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists with this email");
        }

        User user = mapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        
        // Set roles based on DTO
        user.setRoles(Set.of(dto.getRole())); // Ensure this aligns with how roles are stored

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

