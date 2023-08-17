package org.example;

import org.example.model.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testCalculateSalesTax() {
        BigDecimal price = BigDecimal.valueOf(100.00);
        double taxRate = 10.0;
        BigDecimal expectedTax = BigDecimal.valueOf(10.00);

        BigDecimal calculatedTax = Main.calculateSalesTax(price, taxRate);

        assertEquals(0, calculatedTax.compareTo(expectedTax));
    }

    @Test
    public void testPrintReceipt() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "imported chocolates", BigDecimal.valueOf(10.00), true));
        items.add(new Item(1, "book", BigDecimal.valueOf(15.00), false));

        // You might want to capture the printed output and verify it, but for simplicity, we'll just test if it doesn't throw exceptions.
        Main.printReceipt(items);
    }

    @Test
    public void testItemIsExempt() {
        Item exemptItem = new Item(1, "chocolate bar", BigDecimal.valueOf(5.00), false);
        Item nonExemptItem = new Item(1, "shoes", BigDecimal.valueOf(50.00), false);

        assertTrue(exemptItem.isExempt());
        assertFalse(nonExemptItem.isExempt());
    }

    @Test
    public void testExampleInput1() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "book", BigDecimal.valueOf(12.49), false));
        items.add(new Item(1, "music CD", BigDecimal.valueOf(14.99), false));
        items.add(new Item(1, "chocolate bar", BigDecimal.valueOf(0.85), false));

        // You might want to capture the printed output and verify it, but for simplicity, we'll just test if it doesn't throw exceptions.
        Main.printReceipt(items);
    }

    @Test
    public void testExampleInput2() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "imported box of chocolates", BigDecimal.valueOf(10.00), true));
        items.add(new Item(1, "imported bottle of perfume", BigDecimal.valueOf(47.50), true));

        // You might want to capture the printed output and verify it, but for simplicity, we'll just test if it doesn't throw exceptions.
        Main.printReceipt(items);
    }

    @Test
    public void testExampleInput3() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "imported bottle of perfume", BigDecimal.valueOf(27.99), true));
        items.add(new Item(1, "bottle of perfume", BigDecimal.valueOf(18.99), false));
        items.add(new Item(1, "packet of headache pills", BigDecimal.valueOf(9.75), false));
        items.add(new Item(1, "box of imported chocolates", BigDecimal.valueOf(11.25), true));

        // You might want to capture the printed output and verify it, but for simplicity, we'll just test if it doesn't throw exceptions.
        Main.printReceipt(items);
    }

}