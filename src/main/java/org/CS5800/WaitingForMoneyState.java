package org.CS5800;

public class WaitingForMoneyState implements State {
    private final VendingMachine vendingMachine;
    private final String snackName;

    public WaitingForMoneyState(VendingMachine vendingMachine, String snackName) {
        this.vendingMachine = vendingMachine;
        this.snackName = snackName;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Already selected a snack. Insert money.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Money inserted: $" + amount);
        if (vendingMachine.getSnackChain().handleRequest(snackName, amount)) {
            vendingMachine.setState(new DispensingSnackState(vendingMachine));
        } else {
            vendingMachine.setState(new IdleState(vendingMachine));
        }
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Insert money first to dispense the snack.");
    }
}
