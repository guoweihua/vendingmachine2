package machine;

public interface ItemHandler {

    public void dispenseItem();
    
    public void dispenseChips(Chips chips);

    public boolean isValidItem(String itemName);

}
