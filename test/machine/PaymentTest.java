package machine;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PaymentTest {

    @Mock
    MoneyHandler handler;
    
    private Payment payment;
    
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    	payment = new MachineMoneyHandlerPayment();
    }
    
    @Test
    public void shouldVerifyPayment() {
    	handler.receiveMoney(payment);
    	
    	verify(handler).verifyPayment(payment);
    }
	
}
