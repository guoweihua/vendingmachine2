package Machine;

public class Machine {

    private Display display;
    private MoneyHandler moneyHandler;
    private ItemHandler itemHandler;

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Object receivedMoney(double amount) {
        moneyHandler.receiveMoney(amount);
        display.show("money " + amount + " inserted.");
        return null;
    }

    public MoneyHandler getMoneyHandler() {
        return moneyHandler;
    }

    public void setMoneyHandler(MoneyHandler moneyHandler) {
        this.moneyHandler = moneyHandler;
    }

    public ItemHandler getItemHandler() {
        return itemHandler;
    }

    public void setItemHandler(ItemHandler itemHandler) {
        this.itemHandler = itemHandler;
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
