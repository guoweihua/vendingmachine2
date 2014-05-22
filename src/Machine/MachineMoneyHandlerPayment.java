package machine;

public class MachineMoneyHandlerPayment implements Payment {

	private double amount;
	
	@Override
	public double amount() {
		return this.amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
