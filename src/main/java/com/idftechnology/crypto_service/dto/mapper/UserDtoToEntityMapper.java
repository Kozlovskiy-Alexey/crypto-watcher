package com.idftechnology.crypto_service.dto.mapper;

import com.idftechnology.crypto_service.dto.UserDto;
import com.idftechnology.crypto_service.dto.mapper.api.IDtoToEntityMapper;
import com.idftechnology.crypto_service.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityMapper implements IDtoToEntityMapper<User, UserDto> {
    @Override
    public UserDto entityToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .entryPrice(entity.getEntryPrice())
                .build();
    }

    @Override
    public User DtoToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .symbol(dto.getSymbol())
                .build();
    }
}
