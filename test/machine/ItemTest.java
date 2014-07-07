package machine;

import static org.junit.Assert.*;
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
    public void shouldReturnTrueIfChips() {
        assertTrue(handler.isValidItem("chips"));
    }

    @Test
    public void shouldReturnTrueIfSoda() {
        assertTrue(handler.isValidItem("soda"));
    }

    @Test
    public void shouldReturnTrueIfCandy() {
        assertTrue(handler.isValidItem("candy"));
    }

   @Test
    public void shouldReturnFalseIfValidItem() {
        assertFalse(handler.isValidItem("pizza"));
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
