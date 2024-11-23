package org.CS5800;

public class IdleState implements State {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Snack selected: " + snackName);
        vendingMachine.setState(new WaitingForMoneyState(vendingMachine, snackName));
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("No snack selected to dispense.");
    }
}
