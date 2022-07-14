package com.idftechnology.crypto_service.controller;

import com.idftechnology.crypto_service.dto.UserDto;
import com.idftechnology.crypto_service.service.api.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> notify(@RequestBody UserDto dto) {
        UserDto userDto = userService.add(dto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
