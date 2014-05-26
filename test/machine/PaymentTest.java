package machine;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class PaymentTest {

    @InjectMocks
    private Machine machine;
	
    @Spy
    MachineMoneyHandler handler;
    
    @Mock
    Display display;
    
    @Mock
    private Payment payment;
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldVerifyPayment() {
    	machine.receivedMoney(payment);
    	verify(handler).verifyPayment(payment);
    }
	
}
