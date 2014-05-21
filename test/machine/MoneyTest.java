package machine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    private MoneyHandler moneyHandler;

    @Before
    public void setup() {
        moneyHandler = new MachineMoneyHandler();
    }

    @Test
    public void receiveShouldIncreaseAmount() {
        double amountInput = 1.0;
        double amountBefore = moneyHandler.getAmount();
        moneyHandler.receiveMoney(amountInput);

        assertEquals(amountInput, moneyHandler.getAmount() - amountBefore, 0.001);
    }

    @Test
    public void dispensingMoneyShouldDecreaseAmount() {
        double amountDispensed = 1.0;
        double amountBefore = moneyHandler.getAmount();
        moneyHandler.changeMoney(amountDispensed);

        assertEquals(amountDispensed, amountBefore - moneyHandler.getAmount(), 0.001);
    }
}
