package org.CS5800;

public interface State {
    void selectSnack(String snackName);
    void insertMoney(double amount);
    void dispenseSnack();
}
