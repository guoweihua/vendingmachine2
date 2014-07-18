package machine;

public class MoneyHandler {
	private double amountInMachine = 0.0;
	
	public double buy(double inputMoney, double amountToCharge) {
		double change = inputMoney - amountToCharge;
		amountInMachine += amountToCharge;		
		return change;
	}

	public boolean isEnoughMoneyForItem(double moneyAmount, double itemPrice) {
		if(moneyAmount < itemPrice) return false;
		else return true;
	}

	public double getTotal() {
		return amountInMachine;
	}

	public void setTotal(double total) {
		this.amountInMachine = total;
	}
}
