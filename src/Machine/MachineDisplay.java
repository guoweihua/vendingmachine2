package machine;

public class MachineDisplay implements Display {

	public String show(String message) {
		return message;
	}

	public String showChange(double change) {
		return "Change: $" + change;
	}

}
