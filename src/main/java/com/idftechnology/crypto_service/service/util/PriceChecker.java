package com.idftechnology.crypto_service.service.util;

public final class PriceChecker {

    private PriceChecker() {
    };

    public static boolean checkPriceChange(double entryPrice, double currentPrice, double percentPriceChange) {
        double value = (currentPrice / entryPrice - 1) * 100;
        return Math.abs(value) > percentPriceChange;
    }

     public static double getPriceChange(double entryPrice, double currentPrice) {
        return (currentPrice / entryPrice - 1) * 100;
    }

}
