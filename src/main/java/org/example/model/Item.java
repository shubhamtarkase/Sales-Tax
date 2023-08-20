package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
public class Item {
    private final int quantity;
    private final String name;
    private final BigDecimal price;
    private final boolean isImported;
    @Setter
    private BigDecimal salesTax;

    public Item(int quantity, String itemName, BigDecimal price, boolean isImported) {
        this.quantity = quantity;
        this.name = itemName;
        this.price = price;
        this.isImported = isImported;
        salesTax = null;
    }

    public boolean isExempt() {
        String[] exemptKeywords = {"book", "books", "chocolate", "chocolates", "pill", "pills"};

        for (String keyword : exemptKeywords) {
            if (name.toLowerCase().contains(keyword)) {
                return true;
            }
        }

        return false;
    }
}
