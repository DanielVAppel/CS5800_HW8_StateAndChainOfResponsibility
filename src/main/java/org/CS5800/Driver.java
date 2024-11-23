package org.CS5800;

public class Driver {
    public static void main(String[] args) {
        // Initialize vending machine
        VendingMachine vendingMachine = new VendingMachine();

        // Simulate normal flow: Select, insert money, dispense
        System.out.println("=== Scenario 1: Dispense Coke ===");
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();

        // Simulate insufficient funds
        System.out.println("\n=== Scenario 2: Insufficient Funds for Cheetos ===");
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.00);
        vendingMachine.dispenseSnack();

        // Simulate out-of-stock item
        System.out.println("\n=== Scenario 3: Out of Stock (Snickers) ===");
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.25);
        vendingMachine.dispenseSnack();

        // Simulate trying to select a snack after dispensing
        System.out.println("\n=== Scenario 4: Select Snack after Dispensing ===");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        vendingMachine.selectSnack("Doritos");

    }
}
