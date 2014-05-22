package machine;

public class MachineMoneyHandler implements MoneyHandler {

    private double amount = 0;

    @Override
    public void changeMoney(double amount) {
        this.amount -= amount;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

	@Override
	public void receiveMoney(Payment payment) {
		// TODO Auto-generated method stub
		verifyPayment(payment);
	}

	@Override
	public boolean verifyPayment(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

}
