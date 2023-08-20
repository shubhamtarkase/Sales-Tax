package org.example.util;

import org.example.model.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiptTest {
    @Test
    void calculateTotalsShouldCalculateCorrectTotals() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, "book", BigDecimal.valueOf(10.0), false));
        items.add(new Item(1, "imported chocolates", BigDecimal.valueOf(5.0), true));

        Receipt receipt = new Receipt(items);

        assertEquals(BigDecimal.valueOf(0.25), receipt.getTotalSalesTax());
        assertEquals(BigDecimal.valueOf(25.25), receipt.getTotalPrice());
    }

    @Test
    void printReceiptShouldPrintCorrectOutput() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "book", BigDecimal.valueOf(12.49), false));
        items.add(new Item(1, "imported chocolates", BigDecimal.valueOf(5.0), true));

        Receipt receipt = new Receipt(items);

        String expectedOutput = "Output:\n" +
                "1 book: 12.49\n" +
                "1 imported chocolates: 5.25\n" +
                "Sales Taxes: 0.25\n" +
                "Total: 17.74";

        assertEquals(expectedOutput, receipt.printReceipt());
    }
}
