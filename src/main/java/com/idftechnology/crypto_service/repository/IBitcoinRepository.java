package com.idftechnology.crypto_service.repository;

import com.idftechnology.crypto_service.entity.Bitcoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBitcoinRepository extends JpaRepository<Bitcoin, Long> {

    @Query(value = "SELECT * FROM crypto_watcher.btc_price ORDER BY btc_price.id DESC LIMIT 1", nativeQuery = true)
    Bitcoin findCryptoWithLastPrice();


}
