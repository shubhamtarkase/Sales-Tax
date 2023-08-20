package org.example.util;

import org.example.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Execute {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        String ans;
        do {
            getInputDetails(scanner, items);
            Receipt receipt = new Receipt(items);
            System.out.println(receipt.printReceipt());
            items.clear();
            System.out.println("----------------------------");
            System.out.print("Do you want to continue (y/n): ");
            ans = scanner.nextLine();
        } while (ans.equalsIgnoreCase("y"));

        scanner.close();

    }

    private static void getInputDetails(Scanner scanner, List<Item> items) {

        while (true) {
            try {
                System.out.print("Enter item description (or -1 to finish): ");
                String description = scanner.nextLine();

                if (description.equals("-1")) {
                    break;
                }

                Matcher matcher = Pattern.compile("^(\\d+)\\s*(imported)?\\s*(.*?)\\s+at\\s+(\\d+\\.\\d+)$").matcher(description);

                if (matcher.matches()) {
                    int quantity = Integer.parseInt(matcher.group(1));
                    boolean isImported = description.contains("imported") || description.contains("Imported");

                    String itemName = matcher.group(3);
                    if (isImported) {
                        itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
                    }
                    BigDecimal price = new BigDecimal(matcher.group(4));

                    items.add(new Item(quantity, itemName, price, isImported));
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Error processing input. Please enter valid values.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }
}
