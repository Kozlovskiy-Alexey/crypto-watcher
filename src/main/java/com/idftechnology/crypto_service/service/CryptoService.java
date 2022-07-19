package com.idftechnology.crypto_service.service;

import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.dto.mapper.*;
import com.idftechnology.crypto_service.dto.CryptoPageDto;
import com.idftechnology.crypto_service.entity.*;
import com.idftechnology.crypto_service.repository.*;
import com.idftechnology.crypto_service.service.api.CryptoId;
import com.idftechnology.crypto_service.service.api.ICryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CryptoService implements ICryptoService {

    private final ICryptoRepository cryptoRepository;
    private final CryptoCurrencyDtoToEntityMapper dtoToEntityMapper;
    private final IBitcoinRepository bitcoinRepository;
    private final IEthereumRepository ethereumRepository;
    private final ISolanaRepository solanaRepository;
    private final CryptoDtoToBitcoinEntityMapper bitcoinEntityMapper;
    private final CryptoDtoToEthereumEntityMapper ethereumEntityMapper;
    private final CryptoDtoToSolanaEntityMapper solanaEntityMapper;

    @Override
    public CryptoPageDto getCryptoPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Crypto> cryptoPage = cryptoRepository.findAll(pageable);

        return CryptoPageDto.builder()
                .number(page)
                .size(size)
                .totalPages(cryptoPage.getTotalPages())
                .totalElements((int) cryptoPage.getTotalElements())
                .numberOfElements(cryptoPage.getNumberOfElements())
                .first(cryptoPage.isFirst())
                .last(cryptoPage.isLast())
                .content(cryptoPage.getContent().stream()
                        .map(dtoToEntityMapper::entityToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public CryptoDto get(int id) {
        if (id == CryptoId.BTC.getId()) {
            Bitcoin entity = bitcoinRepository.findCryptoWithLastPrice();
            return bitcoinEntityMapper.entityToDto(entity);
        } else if (id == CryptoId.ETH.getId()) {
            Ethereum entity = ethereumRepository.findCryptoWithLastPrice();
            return ethereumEntityMapper.entityToDto(entity);
        } else if (id == CryptoId.SOL.getId()) {
            Solana entity = solanaRepository.findCryptoWithLastPrice();
            return solanaEntityMapper.entityToDto(entity);
        } else {
            throw new IllegalArgumentException("Crypto id not found.");
        }
    }

    @Override
    @Transactional
    public void add(CryptoDto cryptoDto) {
        if (cryptoDto.getId() == CryptoId.BTC.getId()) {
            Bitcoin entity = bitcoinEntityMapper.DtoToEntity(cryptoDto);
            bitcoinRepository.save(entity);
        } else if (cryptoDto.getId() == CryptoId.ETH.getId()) {
            Ethereum entity = ethereumEntityMapper.DtoToEntity(cryptoDto);
            ethereumRepository.save(entity);
        } else if (cryptoDto.getId() == CryptoId.SOL.getId()) {
            Solana entity = solanaEntityMapper.DtoToEntity(cryptoDto);
            solanaRepository.save(entity);
        } else {
            throw new IllegalArgumentException("Crypto id not found.");
        }
    }
}
