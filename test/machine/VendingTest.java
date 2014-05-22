package machine;
import machine.Display;
import machine.ItemHandler;
import machine.Machine;
import machine.MoneyHandler;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;


public class VendingTest {
    @InjectMocks
    private Machine machine;

    @Mock
    Display display;

    @Mock
    MoneyHandler moneyHandler;

    @Mock
    ItemHandler itemHandler;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAcceptCertainAmountOfMoney() {
        Payment payment = new MachineMoneyHandlerPayment();
        payment.setAmount(1.0);
        machine.receivedMoney(payment);
        verify(moneyHandler).receiveMoney(payment);
        verify(display).show("money 1.0 inserted.");
    }

    @Test
    public void shouldDispenseItem() {
        machine.dispenseItem();
        verify(itemHandler).dispenseItem();
        verify(display).show("Item dispensing...");
    }

    @Test
    public void shouldChangeMoney() {
        machine.changeMoney();
        verify(moneyHandler).changeMoney(anyDouble());
        verify(display).show("Please take your change.");
    }

    @Ignore
    @Test
    public void shouldAllowCustomerToBuyItem() {
    }

}
