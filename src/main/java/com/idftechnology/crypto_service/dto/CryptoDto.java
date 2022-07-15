package com.idftechnology.crypto_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "symbol", "name", "rank", "price_usd", "percent_change_24h", "percent_change_1h",
        "percent_change_7d", "market_cap_usd", "volume24", "volume24_native", "csupply", "price_btc", "tsupply",
        "msupply"})
public class CryptoDto implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private int id;

    private String symbol;

    private String name;

    private int rank;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("price_usd")
    private BigDecimal priceUsd;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("percent_change_24h")
    private double percentChange24h;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("percent_change_1h")
    private double percentChange1h;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("percent_change_7d")
    private double percentChange7d;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("market_cap_usd")
    private BigDecimal marketCapUsd;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal volume24;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("volume24_native")
    private BigDecimal volume24Native;

    private BigDecimal csupply;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("price_btc")
    private BigDecimal priceBtc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal tsupply;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal msupply;

}