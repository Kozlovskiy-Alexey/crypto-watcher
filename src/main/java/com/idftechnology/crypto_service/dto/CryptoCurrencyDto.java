package com.idftechnology.crypto_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "symbol", "name", "nameid"})
public class CryptoCurrencyDto implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private int id;

    private String symbol;

    private String name;

    private String nameid;
}
