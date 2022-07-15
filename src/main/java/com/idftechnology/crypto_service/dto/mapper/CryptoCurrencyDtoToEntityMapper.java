package com.idftechnology.crypto_service.dto.mapper;

import com.idftechnology.crypto_service.dto.CryptoCurrencyDto;
import com.idftechnology.crypto_service.dto.mapper.api.IDtoToEntityMapper;
import com.idftechnology.crypto_service.entity.Crypto;
import org.springframework.stereotype.Component;

@Component
public final class CryptoCurrencyDtoToEntityMapper implements IDtoToEntityMapper<Crypto, CryptoCurrencyDto> {

    @Override
    public CryptoCurrencyDto entityToDto(Crypto entity) {
        return CryptoCurrencyDto.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .name(entity.getCryptoName())
                .nameid(entity.getNameId())
                .build();
    }

    @Override
    public Crypto DtoToEntity(CryptoCurrencyDto dto) {
        return Crypto.builder()
                .id(dto.getId())
                .symbol(dto.getSymbol())
                .cryptoName(dto.getName())
                .nameId(dto.getNameid())
                .build();
    }
}
