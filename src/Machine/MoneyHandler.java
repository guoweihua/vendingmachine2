package machine;

public interface MoneyHandler {

    public void receiveMoney(double amount);

    public void changeMoney(double amountDispensed);

    public double getAmount();

}
