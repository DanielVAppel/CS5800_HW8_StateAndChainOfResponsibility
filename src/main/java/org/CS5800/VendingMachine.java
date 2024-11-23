package org.CS5800;

public class VendingMachine {
    private State currentState;
    private SnackDispenseHandler snackChain;

    public VendingMachine() {
        this.currentState = new IdleState(this);
        setupSnackChain();
    }

    private void setupSnackChain() {
        SnackDispenseHandler cokeHandler = new Snack("Coke", 1.50, 5);
        SnackDispenseHandler pepsiHandler = new Snack("Pepsi", 1.50, 3);
        SnackDispenseHandler cheetosHandler = new Snack("Cheetos", 2.00, 4);
        SnackDispenseHandler doritosHandler = new Snack("Doritos", 2.00, 0); // out of stock
        SnackDispenseHandler kitkatHandler = new Snack("KitKat", 1.25, 2);
        SnackDispenseHandler snickersHandler = new Snack("Snickers", 1.25, 0); // out of stock

        // Linking the chain
        cokeHandler.setNext(pepsiHandler);
        pepsiHandler.setNext(cheetosHandler);
        cheetosHandler.setNext(doritosHandler);
        doritosHandler.setNext(kitkatHandler);
        kitkatHandler.setNext(snickersHandler);

        this.snackChain = cokeHandler;
    }
    public void selectSnack(String snackName) {
        currentState.selectSnack(snackName);
    }
    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }
    public void dispenseSnack() {
        currentState.dispenseSnack();
    }
    public void setState(State state) {
        this.currentState = state;
    }
    public SnackDispenseHandler getSnackChain() {
        return snackChain;
    }
}
