package org.CS5800;

public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler next;
    protected String snackName;
    protected double price;
    protected int quantity;

    public SnackDispenseHandler(String snackName, double price, int quantity) {
        this.snackName = snackName;
        this.price = price;
        this.quantity = quantity;
    }

    public void setNext(SnackDispenseHandler next) {
        this.next = next;
    }

    public boolean handleRequest(String snackName, double amount) {
        if (this.snackName.equals(snackName)) {
            if (amount >= price && quantity > 0) {
                quantity--;
                System.out.println(snackName + " dispensed. Remaining quantity: " + quantity);
                return true;
            } else if (quantity == 0) {
                System.out.println(snackName + " is out of stock.");
                return false;
            } else {
                System.out.println("Insufficient funds for " + snackName + ".");
                return false;
            }
        } else if (next != null) {
            return next.handleRequest(snackName, amount);
        }
        System.out.println(snackName + " not available in the vending machine.");
        return false;
    }
}
