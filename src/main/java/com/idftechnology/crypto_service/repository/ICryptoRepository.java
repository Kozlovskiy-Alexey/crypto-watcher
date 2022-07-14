package com.idftechnology.crypto_service.repository;

import com.idftechnology.crypto_service.entity.Crypto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ICryptoRepository extends PagingAndSortingRepository<Crypto, Integer> {

    Optional<Crypto> findBySymbol(String symbol);
}
