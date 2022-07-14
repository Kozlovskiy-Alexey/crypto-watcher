package com.idftechnology.crypto_service.service.api;

import com.idftechnology.crypto_service.dto.CryptoDto;

public interface IRestService {

    /**
     * Obtaining actual information about cryptocurrency from CoinLore API.
     *
     * @param id cryptocurrency id.
     */
    CryptoDto get(int id);
}
