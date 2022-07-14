package com.idftechnology.crypto_service.dto.mapper;

import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.dto.mapper.api.IDtoToEntityMapper;
import com.idftechnology.crypto_service.entity.Ethereum;
import com.idftechnology.crypto_service.service.api.CryptoId;
import org.springframework.stereotype.Component;

@Component
public class CryptoDtoToEthereumEntityMapper implements IDtoToEntityMapper<Ethereum, CryptoDto> {

    @Override
    public CryptoDto entityToDto(Ethereum entity) {
        return CryptoDto.builder()
                .id(entity.getCryptoId())
                .symbol(CryptoId.ETH.getSymbol())
                .name(CryptoId.ETH.getName())
                .rank(entity.getRank())
                .priceUsd(entity.getPriceUsd())
                .percentChange24h(entity.getPercentChange24h())
                .percentChange1h(entity.getPercentChange1h())
                .percentChange7d(entity.getPercentChange7d())
                .marketCapUsd(entity.getMarketCapUsd())
                .volume24(entity.getVolume24())
                .volume24Native(entity.getVolume24Native())
                .csupply(entity.getCsupply())
                .priceBtc(entity.getPriceBtc())
                .tsupply(entity.getTsupply())
                .msupply(entity.getMsupply())
                .build();
    }

    @Override
    public Ethereum DtoToEntity(CryptoDto dto) {
        return Ethereum.builder()
                .cryptoId(dto.getId())
                .rank(dto.getRank())
                .priceUsd(dto.getPriceUsd())
                .percentChange24h(dto.getPercentChange24h())
                .percentChange1h(dto.getPercentChange1h())
                .percentChange7d(dto.getPercentChange7d())
                .marketCapUsd(dto.getMarketCapUsd())
                .volume24(dto.getVolume24())
                .volume24Native(dto.getVolume24Native())
                .csupply(dto.getCsupply())
                .priceBtc(dto.getPriceBtc())
                .tsupply(dto.getTsupply())
                .msupply(dto.getMsupply())
                .build();
    }
}
