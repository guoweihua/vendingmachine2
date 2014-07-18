package machine;

public class ConsoleDisplay implements Display {

	@Override
	public void show(String message) {
		System.out.println(message);
	}

}
