package com.idftechnology.crypto_service.repository;

import com.idftechnology.crypto_service.entity.Solana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISolanaRepository extends JpaRepository<Solana, Long> {

    @Query(value = "SELECT * FROM crypto_watcher.sol_price ORDER BY sol_price.id DESC LIMIT 1", nativeQuery = true)
    Solana findCryptoWitLastPrice();
}
