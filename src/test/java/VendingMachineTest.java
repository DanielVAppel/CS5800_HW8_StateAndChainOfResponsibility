
import static org.junit.jupiter.api.Assertions.*;

import org.CS5800.SnackDispenseHandler;
import org.CS5800.VendingMachine;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    @Test
    public void testSelectSnack() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Coke");
        assertNotNull(vendingMachine.getSnackChain());
    }

    @Test
    public void testInsertMoney() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(1.50);
        assertNotNull(vendingMachine.getSnackChain());
    }

    @Test
    public void testDispenseSnack() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();
    }

    @Test
    public void testOutOfStock() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.25);
        vendingMachine.dispenseSnack();
    }

    @Test
    public void testInsufficientFunds() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.00);
        vendingMachine.dispenseSnack();
    }

    @Test
    public void testSnackHandlerLinking() {
        VendingMachine vendingMachine = new VendingMachine();
        SnackDispenseHandler handler = vendingMachine.getSnackChain();
        assertNotNull(handler);
    }
}
