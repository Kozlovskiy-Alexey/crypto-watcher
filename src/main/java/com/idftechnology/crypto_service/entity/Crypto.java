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

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crypto", schema = "crypto_watcher")
public class Crypto implements Serializable {

    @Id
    private Integer id;
    private String symbol;

    @Column(name = "crypto_name")
    private String cryptoName;

    @Column(name = "name_id")
    private String nameId;
}
