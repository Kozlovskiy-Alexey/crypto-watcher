package com.idftechnology.crypto_service.service.api;

public enum CryptoId {

    BTC(90, "BTC", "Bitcoin", "bitcoin"),
    ETH(80, "ETH", "Ethereum", "ethereum"),
    SOL(48543, "SOL", "Solana", "solana");

    private final int id;
    private final String symbol;
    private final String name;
    private final String nameId;

    CryptoId(int id, String symbol, String name, String nameId) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameId = nameId;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getNameId() {
        return nameId;
    }
}