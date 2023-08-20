package org.example.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

class TaxCalculator {
    public static BigDecimal calculateSalesTax(BigDecimal price, double taxRate) {
        BigDecimal tax = price.multiply(BigDecimal.valueOf(taxRate / 100));
        BigDecimal roundedTax = tax.divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP)
                .multiply(BigDecimal.valueOf(0.05));
        return roundedTax;
    }
}