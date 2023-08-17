package org.example;

import org.example.model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static BigDecimal calculateSalesTax(BigDecimal price, double taxRate) {
        BigDecimal tax = price.multiply(BigDecimal.valueOf(taxRate / 100));
        return tax.divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP)
                .multiply(BigDecimal.valueOf(0.05));
    }

    public static void printReceipt(List<Item> items) {
        BigDecimal totalSalesTax = BigDecimal.ZERO;
        BigDecimal totalPrice = BigDecimal.ZERO;

        System.out.println("Output:");

        for (Item item : items) {
            BigDecimal salesTax = BigDecimal.ZERO;

            if (!item.isExempt() && !item.isImported) {
                salesTax = salesTax.add(calculateSalesTax(item.price, 10));
            } else if (!item.isExempt() && item.isImported) {
                salesTax = salesTax.add(calculateSalesTax(item.price, 15));
            } else if (item.isExempt() && item.isImported) {
                salesTax = salesTax.add(calculateSalesTax(item.price, 5));
            }

            BigDecimal itemTotal = item.price.add(salesTax);
            totalSalesTax = totalSalesTax.add(salesTax);
            totalPrice = totalPrice.add(itemTotal);

            System.out
                    .println(item.quantity + " " + (item.isImported ? "imported " : "") + item.name + ": " + itemTotal);
        }

        System.out.println("Sales Taxes: " + totalSalesTax);
        System.out.println("Total: " + totalPrice);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Item> items = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Enter item quantity (or -1 to finish): ");
                int quantity = scanner.nextInt();
                if (quantity == -1) {
                    break;
                }

                scanner.nextLine(); // Consume newline

                System.out.print("Enter item name: ");
                String name = scanner.nextLine();

                System.out.print("Enter item price: ");
                BigDecimal price = scanner.nextBigDecimal();

                System.out.print("Is item imported (true/false): ");
                boolean isImported = scanner.nextBoolean();

                items.add(new Item(quantity, name, price, isImported));
            } catch (Exception e) {
                System.out.println("Error processing input. Please enter valid values.");
                scanner.nextLine(); // Clear input buffer
            }
        }

        scanner.close();

        printReceipt(items);
    }

}