package com.idftechnology.crypto_service.dto.util;

import com.idftechnology.crypto_service.advice.ResponseError;
import com.idftechnology.crypto_service.advice.SingleValidateException;
import com.idftechnology.crypto_service.dto.UserDto;
import com.idftechnology.crypto_service.entity.Crypto;
import com.idftechnology.crypto_service.entity.User;
import com.idftechnology.crypto_service.repository.ICryptoRepository;
import com.idftechnology.crypto_service.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserDtoValidator {

    private final static String REGEX_USER_ID = "^[a-zA-Z0-9]+@[a-zA-Z]{2,}\\.[a-zA-Z]{2,7}";

    private final ICryptoRepository cryptoRepository;
    private final IUserRepository userRepository;

    public UserDtoValidator(ICryptoRepository cryptoRepository, IUserRepository userRepository) {
        this.cryptoRepository = cryptoRepository;
        this.userRepository = userRepository;
    }

    public void validateDto(UserDto dto) {
        String error = "";


        if (dto.getId().isEmpty()) {
            error = error.concat("Id should not be empty. ");
        }
        if (!validateId(dto.getId())) {
            error = error.concat("Id must be an email. ");
        }
        if (dto.getSymbol().isEmpty()) {
            error = error.concat("Symbol should not be empty.");
        }
        Optional<User> mayBeUser = userRepository.findById(dto.getId());
        if (mayBeUser.isPresent()) {
            error = error.concat("User with this id already exists. ");
        }
        if (!error.isEmpty()) {
            throw new SingleValidateException(new ResponseError(error.trim()));
        }
    }

    private boolean validateId(String id) {
        Pattern pattern = Pattern.compile(REGEX_USER_ID);
        Matcher matcher = pattern.matcher(id);
        return matcher.find();
    }

}
