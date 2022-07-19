package com.idftechnology.crypto_service.repository;

import com.idftechnology.crypto_service.entity.Ethereum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEthereumRepository extends JpaRepository<Ethereum, Long> {

    @Query(value = "SELECT * FROM crypto_watcher.eth_price ORDER BY eth_price.id DESC LIMIT 1", nativeQuery = true)
    Ethereum findCryptoWithLastPrice();
}
