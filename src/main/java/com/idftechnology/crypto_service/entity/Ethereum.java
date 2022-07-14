package com.idftechnology.crypto_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Double priceUsd;

    @Column(name = "percent_change_24h")
    private Double percentChange24h;

    @Column(name = "percent_change_1h")
    private Double percentChange1h;

    @Column(name = "percent_change_7d")
    private Double percentChange7d;

    @Column(name = "market_cap_usd")
    private Double marketCapUsd;

    private Double volume24;

    @Column(name = "volume24_native")
    private Double volume24Native;

    private Double csupply;

    @Column(name = "price_btc")
    private Double priceBtc;

    private Double tsupply;

    private Double msupply;


}
