package machine;

public class Machine {

    private Display display;
    private MoneyHandler moneyHandler;
    private ItemHandler itemHandler;

    public Machine(Display display, MoneyHandler moneyHandler, ItemHandler itemHandler) {
    	this.display = display;
    	this.moneyHandler = moneyHandler;
    	this.itemHandler = itemHandler;
    }

    public Object receivedMoney(double amount) {
        moneyHandler.receiveMoney(amount);
        display.show("money " + amount + " inserted.");
        return null;
    }

    public void dispenseItem() {
        itemHandler.dispenseItem();
        display.show("Item dispensing...");

    }

    public void changeMoney() {
        moneyHandler.changeMoney();
        display.show("Please take your change.");

    }

    public void displayMoneyInserted() {
        // TODO Auto-generated method stub

    }

    public void buyItem() {
        // TODO Auto-generated method stub

    }

}
