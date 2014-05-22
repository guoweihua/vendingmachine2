package machine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MoneyTest {
    private MoneyHandler moneyHandler;
    
    @Before
    public void setup() {
        moneyHandler = new MachineMoneyHandler();
    }

    @Test
    public void receiveShouldIncreaseAmount() {
        Payment paymentInput = new MachineMoneyHandlerPayment();
        double amountBefore = moneyHandler.getAmount();
        moneyHandler.receiveMoney(paymentInput);

        assertEquals(paymentInput.amount(), moneyHandler.getAmount() - amountBefore, 0.001);
    }

    @Test
    public void dispensingMoneyShouldDecreaseAmount() {
        double amountDispensed = 1.0;
        double amountBefore = moneyHandler.getAmount();
        moneyHandler.changeMoney(amountDispensed);

        assertEquals(amountDispensed, amountBefore - moneyHandler.getAmount(), 0.001);
    }
    
}
