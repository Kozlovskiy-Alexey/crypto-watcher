package com.idftechnology.crypto_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"id", "symbol", "entry_price"})
public class UserDto implements Serializable {

    private String id;
    private String symbol;

    @JsonProperty("entry_price")
    private BigDecimal entryPrice;
}
