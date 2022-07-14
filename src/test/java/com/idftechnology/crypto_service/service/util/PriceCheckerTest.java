package com.idftechnology.crypto_service.service.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PriceCheckerTest {

    @ParameterizedTest
    @MethodSource("com.idftechnology.crypto_service.service.util.PriceCheckerTest#getArgumentsForChangePriceMorThenOnePercentTest")
    void changePriceMorThenOnePercent(double entryPrice, double currentPrice) {
        boolean change = PriceChecker.checkPriceChange(entryPrice, currentPrice);
        assertTrue(change);
    }

    static Stream<Arguments> getArgumentsForChangePriceMorThenOnePercentTest() {
        return Stream.of(
                Arguments.of(100.32, 1500),
                Arguments.of(98.03, 88.05),
                Arguments.of(0.01, 0.02)
        );
    }
}
