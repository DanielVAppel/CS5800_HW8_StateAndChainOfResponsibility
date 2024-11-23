package org.CS5800;

public class DispensingSnackState implements State {
    private final VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Dispensing snack... Enjoy!");
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
