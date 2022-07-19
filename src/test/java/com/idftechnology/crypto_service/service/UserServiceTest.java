package com.idftechnology.crypto_service.service;

import com.idftechnology.crypto_service.dto.UserDto;
import com.idftechnology.crypto_service.service.api.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

    @Autowired
    private IUserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        UserDto user = UserDto.builder()
                .id("new3@gmail.com")
                .symbol("BTC")
                .build();
        UserDto userDto = userService.add(user);
        assertNotNull(userDto.getEntryPrice());
    }


}