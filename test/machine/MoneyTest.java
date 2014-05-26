package machine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    private static final double PRECISION = 0.001;
	private MoneyHandler moneyHandler;

    @Before
    public void setup() {
        moneyHandler = new MachineMoneyHandler();
    }

    @Test
    public void receiveShouldIncreaseAmount() {
        Payment payment = new MachineMoneyHandlerPayment();
        double amountBefore = moneyHandler.getAmount();
        moneyHandler.receiveMoney(payment);

        assertEquals(payment.amount(), moneyHandler.getAmount() - amountBefore, PRECISION);
    }

    @Test
    public void dispensingMoneyShouldDecreaseAmount() {
        double amountDispensed = 1.0;
        double amountBefore = moneyHandler.getAmount();
        moneyHandler.changeMoney(amountDispensed);

        assertEquals(amountDispensed, amountBefore - moneyHandler.getAmount(), 0.001);
    }
}
