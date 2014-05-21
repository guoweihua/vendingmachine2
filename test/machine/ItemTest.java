package machine;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ItemTest {

    @Mock
    MachineBin machineBin;
    
    @Mock
    Chips chips;
    
	private ItemHandler handler;
	
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        handler = new MachineItemHandler(machineBin);
    }
	
	@Test
	public void shouldDispenseItem() {
		handler.dispenseItem();
		
		verify(machineBin).listItems();	
	}
	
	@Test
	public void shouldAddItemsToBin() {
		handler.dispenseChips(chips);
		
		verify(machineBin).addItem(chips);
	}
	
	
}
