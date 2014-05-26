package machine;

public class MachineMoneyHandler implements MoneyHandler {

    private double amount = 0;

    @Override
<<<<<<< HEAD
=======
    public void receiveMoney(double amount) {
        this.amount += amount;
    }

    @Override
>>>>>>> 8deaa732108d0f69a86baebcf35c0d134c86739f
    public void changeMoney(double amount) {
        this.amount -= amount;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

<<<<<<< HEAD
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

=======
>>>>>>> 8deaa732108d0f69a86baebcf35c0d134c86739f
}
