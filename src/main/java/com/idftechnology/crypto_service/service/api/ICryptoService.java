package com.idftechnology.crypto_service.service.api;

import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.dto.CryptoPageDto;

public interface ICryptoService {

    /**
     * Method returns a list of available cryptocurrencies.
     *
     * @param page returned page number.
     * @param size number of items per page.
     * @return CryptoPageDto cryptocurrencies page.
     */
    CryptoPageDto getCryptoPage(int page, int size);


    /**
     * Getting information about the last price of the cryptocurrency by id.
     *
     * @param id cryptocurrency id.
     * @return CryptoDto contains last price.
     */
    CryptoDto get(int id);

    /**
     * Method adds information about the cryptocurrency quot to the database.
     *
     * @param cryptoDto actual information about cryptocurrency from CoinLore API.
     */
    void add(CryptoDto cryptoDto);

}
