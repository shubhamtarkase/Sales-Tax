package org.example.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxCalculatorTest {
    @Test
    void calculateSalesTaxShouldRoundUpCorrectly() {
        BigDecimal tax = TaxCalculator.calculateSalesTax(BigDecimal.valueOf(28.28), 10);
        assertEquals(BigDecimal.valueOf(2.85), tax);
    }
}
