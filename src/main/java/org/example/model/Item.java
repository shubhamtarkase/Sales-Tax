package org.example.model;

import java.math.BigDecimal;

public class Item {
    public int quantity;
    public String name;
    public BigDecimal price;
    public boolean isImported;

    public Item(int quantity, String name, BigDecimal price, boolean isImported) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.isImported = isImported;
    }

    public boolean isExempt() {
        String[] exemptKeywords = {"book", "chocolates", "chocolate", "pills"};
        
        for (String keyword : exemptKeywords) {
            if (name.toLowerCase().contains(keyword)) {
                return true;
            }
        }
        
        return false;
    }
}