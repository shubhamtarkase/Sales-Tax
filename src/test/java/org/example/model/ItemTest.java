package org.example.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemTest {
    @Test
    void isExemptShouldReturnTrueForExemptKeywords() {
        Item item = new Item(1, "chocolate", BigDecimal.valueOf(5.0), false);
        assertTrue(item.isExempt());
    }

    @Test
    void isExemptShouldReturnFalseForNonExemptKeywords() {
        Item item = new Item(1, "shoes", BigDecimal.valueOf(50.0), false);
        assertFalse(item.isExempt());
    }
}