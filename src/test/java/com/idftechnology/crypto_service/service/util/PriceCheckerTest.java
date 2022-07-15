package com.idftechnology.crypto_service.service.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PriceCheckerTest {

    @ParameterizedTest
    @MethodSource("com.idftechnology.crypto_service.service.util.PriceCheckerTest#getArgumentsForChangePriceMorThenOnePercentTest")
    void changePriceMorThenOnePercent(BigDecimal entryPrice, BigDecimal currentPrice) {
        boolean change = PriceChecker.checkPriceChange(entryPrice, currentPrice, 1);
        assertTrue(change);
    }

    static Stream<Arguments> getArgumentsForChangePriceMorThenOnePercentTest() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(1000), BigDecimal.valueOf(1500)),
                Arguments.of(BigDecimal.valueOf(98.03), BigDecimal.valueOf(88.05)),
                Arguments.of(BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02))
        );
    }
}
