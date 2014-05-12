import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import Machine.Display;
import Machine.ItemHandler;
import Machine.Machine;
import Machine.MoneyHandler;

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
        double amount = 1.00;
        machine.receivedMoney(amount);
        verify(moneyHandler).receiveMoney(amount);
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
        verify(moneyHandler).changeMoney();
        verify(display).show("Please take your change.");
    }

    @Ignore
    @Test
    public void shouldAllowCustomerToBuyItem() {
    }

}
