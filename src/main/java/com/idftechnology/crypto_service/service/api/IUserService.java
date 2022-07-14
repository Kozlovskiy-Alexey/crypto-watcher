package com.idftechnology.crypto_service.service.api;

import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.dto.UserDto;

public interface IUserService {

    /**
     * User registration method with reference to the current cryptocurrency price.
     *
     * @param dto formed from the Request body, contains from crypto id and symbol.
     * @return saved UserDto.
     */
    UserDto add(UserDto dto);

    /**
     * Method notifies about price change.
     *
     * @param dto contains actual information about cryptocurrency from CoinLore API.
     * @param percentPriceChange percentage price change.
     */
    void warnPriceChange(CryptoDto dto, double percentPriceChange);

}
