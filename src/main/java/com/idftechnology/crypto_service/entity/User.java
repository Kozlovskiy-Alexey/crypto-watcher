package com.idftechnology.crypto_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "crypto_watcher")
public class User implements Serializable {

    @Id
    private String id;
    private String symbol;

    @Column(name = "entry_price")
    private BigDecimal entryPrice;
}
