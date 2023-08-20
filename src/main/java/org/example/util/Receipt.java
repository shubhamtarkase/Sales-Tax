package org.example.util;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Item;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Receipt {
    private List<Item> items;
    private BigDecimal totalSalesTax = BigDecimal.ZERO;
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public Receipt(List<Item> items) {
        this.items = items;
        calculateTotals();
    }

    private void calculateTotals() {
        for (Item item : items) {
            BigDecimal salesTax = BigDecimal.ZERO;

            if (!item.isExempt() && item.isImported()) {
                salesTax = salesTax.add(TaxCalculator.calculateSalesTax(item.getPrice(), 15));
            } else if (!item.isExempt()) {
                salesTax = salesTax.add(TaxCalculator.calculateSalesTax(item.getPrice(), 10));
            } else if (item.isImported()) {
                salesTax = salesTax.add(TaxCalculator.calculateSalesTax(item.getPrice(), 5));
            }
            item.setSalesTax(salesTax);
            BigDecimal itemTotal = item.getPrice().add(salesTax).multiply(BigDecimal.valueOf(item.getQuantity()));
            totalSalesTax = totalSalesTax.add(salesTax.multiply(BigDecimal.valueOf(item.getQuantity())));
            totalPrice = totalPrice.add(itemTotal);
        }
    }

    String printReceipt() {
        StringBuilder formattedReceipt = new StringBuilder();
        formattedReceipt.append("Output:\n");

        for (Item item : items) {
            BigDecimal itemTotal = item.getSalesTax().add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            formattedReceipt.append(item.getQuantity()).append(" ").append(item.isImported() ? "imported " : "")
                    .append(item.getName().replace("imported ", "")).append(": ").append(itemTotal).append("\n");
        }

        formattedReceipt.append("Sales Taxes: ").append(totalSalesTax).append("\n");
        formattedReceipt.append("Total: ").append(totalPrice);

        return formattedReceipt.toString();
    }

}