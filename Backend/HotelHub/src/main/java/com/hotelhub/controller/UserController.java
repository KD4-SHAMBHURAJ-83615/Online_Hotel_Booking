package com.hotelhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hotelhub.dto.UserRegisterDTO;
import com.hotelhub.dto.AuthRequest;
import com.hotelhub.dto.UserRespDTO;
import com.hotelhub.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO dto) {
        userService.registerUser(dto);
        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest dto) {
        UserRespDTO user = userService.authenticateUser(dto);
        return ResponseEntity.ok(user);
    }
}
