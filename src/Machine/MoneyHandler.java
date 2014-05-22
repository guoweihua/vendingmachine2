package machine;

public interface MoneyHandler {

    public void receiveMoney(Payment payment);

    public void changeMoney(double amountDispensed);

    public double getAmount();

	public boolean verifyPayment(Payment payment);

}
