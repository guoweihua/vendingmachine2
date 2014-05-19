package machine;

public class MachineItemHandler implements ItemHandler {

	private ItemBin machineBin;

	public MachineItemHandler(MachineBin bin){
		this.machineBin = bin;
	}
	
	public void dispenseItem() {
		machineBin.listItems();
	}

	public void dispenseChips(Chips chips) {
		machineBin.addItem(chips);
		machineBin.listItems();
	}

}
