package com.idftechnology.crypto_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "eth_price", schema = "crypto_watcher")
public class Ethereum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crypto_id")
    private Integer cryptoId;

    private Integer rank;

    @Column(name = "price_usd")
    private BigDecimal priceUsd;

    @Column(name = "percent_change_24h")
    private Double percentChange24h;

    @Column(name = "percent_change_1h")
    private Double percentChange1h;

    @Column(name = "percent_change_7d")
    private Double percentChange7d;

    @Column(name = "market_cap_usd")
    private BigDecimal marketCapUsd;

    private BigDecimal volume24;

    @Column(name = "volume24_native")
    private BigDecimal volume24Native;

    private BigDecimal csupply;

    @Column(name = "price_btc")
    private BigDecimal priceBtc;

    private BigDecimal tsupply;

    private BigDecimal msupply;

}
