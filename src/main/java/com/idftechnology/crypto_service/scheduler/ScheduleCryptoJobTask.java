package com.idftechnology.crypto_service.scheduler;

import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.entity.Crypto;
import com.idftechnology.crypto_service.repository.ICryptoRepository;
import com.idftechnology.crypto_service.service.api.ICryptoService;
import com.idftechnology.crypto_service.service.api.IRestService;
import com.idftechnology.crypto_service.service.api.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCryptoJobTask implements Runnable {

    @Value(value = "${percent.price.change}")
    private double percentPriceChange;

    private final ICryptoService cryptoService;
    private final ICryptoRepository cryptoRepository;
    private final IRestService restService;
    private final IUserService userService;

    public ScheduleCryptoJobTask(ICryptoService cryptoService, ICryptoRepository cryptoRepository,
                                 IRestService restService, IUserService userService) {
        this.cryptoService = cryptoService;
        this.cryptoRepository = cryptoRepository;
        this.restService = restService;
        this.userService = userService;
    }

    @Override
    public void run() {
        Iterable<Crypto> cryptos = cryptoRepository.findAll();
        for (Crypto crypto : cryptos) {
            Integer id = crypto.getId();
            CryptoDto cryptoDto = restService.get(id);
            cryptoService.add(cryptoDto);
            userService.warnPriceChange(cryptoDto, percentPriceChange);
        }
    }
}
