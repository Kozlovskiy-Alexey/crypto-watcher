package com.idftechnology.crypto_service.service.util;

import java.math.BigDecimal;

public final class PriceChecker {

    private PriceChecker() {
    };

    public static boolean checkPriceChange(BigDecimal entryPrice, BigDecimal currentPrice, double percentPriceChange) {
        double value = (currentPrice.doubleValue() / entryPrice.doubleValue() - 1) * 100;
        return Math.abs(value) > percentPriceChange;
    }

     public static double getPriceChange(BigDecimal entryPrice, BigDecimal currentPrice) {
        return (currentPrice.doubleValue() / entryPrice.doubleValue() - 1) * 100;
    }

}
