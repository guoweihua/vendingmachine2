package machine;

import java.util.ArrayList;
import java.util.List;

public class MachineItemHandler implements ItemHandler {

	private ItemBin machineBin;

    private List<Item> items = new ArrayList<Item>();

	public MachineItemHandler(MachineBin bin){
		this.machineBin = bin;
        addItems();
    }

    private void addItems() {
        items.add(new Soda());
        items.add(new Chips());
        items.add(new Candy());
    }

	public void dispenseItem() {
		machineBin.listItems();
	}

	public void dispenseChips(Chips chips) {
		machineBin.addItem(chips);
		machineBin.listItems();
	}

    @Override
    public boolean isValidItem(String itemName) {
        for (Item item : items) {
            if (item.itemName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

}
