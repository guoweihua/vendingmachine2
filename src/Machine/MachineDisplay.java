package machine;

public class MachineDisplay implements Display {

	public String show(String message) {
		return message;
	}

	public String showMoney(double amount) {
		return "Amount: $" + amount;
	}

}
