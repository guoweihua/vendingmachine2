package machine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DisplayTest {

    private Display display;

	@Before
    public void setup() {
		display = new MachineDisplay();
    }
	
	@Test
	public void shouldDisplayMessagePassedToIt() {
		assertEquals("Message Sent", display.show("Message Sent"));
	}
	
	@Test
	public void shouldShowChangeMessage() {
		assertEquals("Change: $0.75", display.showChange(.75));
	}
	
}
