package com.idftechnology.crypto_service.service;

import com.idftechnology.crypto_service.advice.ResponseError;
import com.idftechnology.crypto_service.advice.SingleValidateException;
import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.service.api.IRestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService implements IRestService {

    private final static String URL_GET_CRYPTO_COST = "https://api.coinlore.net/api/ticker/?id={id}";
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public CryptoDto get(int id) {
        try {
            CryptoDto[] cryptoDtos = restTemplate.getForEntity(
                    URL_GET_CRYPTO_COST,
                    CryptoDto[].class,
                    id).getBody();
            return cryptoDtos[0];
        } catch (Exception e) {
            throw new SingleValidateException(new ResponseError("Error while sending request to CoinLore API"));
        }
    }
}
