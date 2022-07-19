package com.idftechnology.crypto_service.service;

import com.idftechnology.crypto_service.advice.ResponseError;
import com.idftechnology.crypto_service.advice.SingleValidateException;
import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.dto.UserDto;
import com.idftechnology.crypto_service.dto.mapper.UserDtoToEntityMapper;
import com.idftechnology.crypto_service.dto.util.UserDtoValidator;
import com.idftechnology.crypto_service.entity.Crypto;
import com.idftechnology.crypto_service.entity.User;
import com.idftechnology.crypto_service.repository.ICryptoRepository;
import com.idftechnology.crypto_service.repository.IUserRepository;
import com.idftechnology.crypto_service.service.api.IRestService;
import com.idftechnology.crypto_service.service.api.IUserService;
import com.idftechnology.crypto_service.service.util.PriceChecker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final UserDtoToEntityMapper userDtoToEntityMapper;
    private final IRestService restService;
    private final ICryptoRepository cryptoRepository;
    private final UserDtoValidator userDtoValidator;

    @Override
    @Transactional
    public UserDto add(UserDto dto) {
        userDtoValidator.validateDto(dto);
        Optional<Crypto> mayBeSymbol = cryptoRepository.findBySymbol(dto.getSymbol());
        if (mayBeSymbol.isEmpty()) {
            throw new SingleValidateException(new ResponseError("Symbol " + dto.getSymbol() + " not found."));
        } else {
            CryptoDto cryptoDto = restService.get(mayBeSymbol.get().getId());
            User entity = userDtoToEntityMapper.DtoToEntity(dto);
            entity.setEntryPrice(cryptoDto.getPriceUsd());
            User save = userRepository.save(entity);
            return userDtoToEntityMapper.entityToDto(save);
        }
    }

    @Override
    public void warnPriceChange(CryptoDto dto, double percentPriceChange) {
        List<User> allUsers = userRepository.findBySymbol(dto.getSymbol());
        List<User> users = allUsers.stream()
                .filter(u -> PriceChecker.checkPriceChange(u.getEntryPrice(), dto.getPriceUsd(), percentPriceChange))
                .collect(Collectors.toList());
        users.forEach(u -> log.warn("crypto id: " + dto.getId() + ", user: " + u.getId() + ", price change %: "
                + PriceChecker.getPriceChange(u.getEntryPrice(), dto.getPriceUsd())));
    }
}
