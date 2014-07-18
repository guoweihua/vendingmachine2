package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Machine {
	private double moneyinDepositor = 0.0;
	private double moneyInChanger = 0.0;
	private Item itemInBin = null;
	private Display display = new ConsoleDisplay();
	private String itemCodeSelected = null;
	private String status = "Start";
	VendingUnit vendingUnit = new VendingUnit();
	
	private void init() {
		vendingUnit.addItem(new Chips(), 10);
		vendingUnit.addItem(new Candy(), 10);
	}
	
	@Override
	public String toString() {
		return "Machine [moneyinDepositor=" + moneyinDepositor
				+ ", moneyInChanger=" + moneyInChanger + ", itemInBin="
				+ itemInBin + ", itemCodeSelected=" + itemCodeSelected
				+ ", status=" + status + ", vendingUnit=" + vendingUnit + "]";
	}

	private void showStatus() {
		System.out.println(toString());
	}
	
	/* user events */
	private void depositeMoney(double amount) {
		moneyinDepositor += amount;
		display.show("Money deposited.");
	}
	
	private void selectItem(String itemCode){
		this.itemCodeSelected = itemCode;
		display.show("Item selected.");
	}
	
	public void vend() {
		VendingIO vendingIO = new VendingIO();
		vendingIO.setItemCode(itemCodeSelected);
		vendingIO.setInputMoney(moneyinDepositor);
		
		vendingUnit.vending(vendingIO);
		
		String vendingStatus = vendingIO.getStatus();
		if("Validated".equals(vendingStatus)) {
			takeMoney();
			dispenseItem(vendingIO.getItem());
			giveChange(vendingIO.getChange());
			clearItemSelection();
			
			display.show("Please take your item and change.");
		} else {
			display.show("Can not process purchase, " + vendingIO.getMessage());
		}
	}
	
	private void cancelPurchase() {
		itemCodeSelected = null;
		display.show("Purchase cancelled, Please take your money in disposor.");
	}
	
	private void exit() {
		System.exit(0);
	}

	/* actions machine makes*/
	private void takeMoney() {
		moneyinDepositor = 0.0;
	}
	
	private void dispenseItem(Item item) {
		itemInBin = item;
	}
	
	private void giveChange(double amount) {
		moneyInChanger = amount;
	}
	
	private void clearItemSelection() {
		itemCodeSelected = null;
	}
	
	private void show(String message){
		display.show(message);
	}
	
	/* events user can take after transaction*/
	private void takeDepositeMoney() {
		moneyinDepositor = 0.0;		
	}
	
	private void takeItem() {
		itemInBin = null;
	}
	
	private void takeChange() {
		moneyInChanger = 0.0;
	}
	
	
	/* flow control */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		Machine machine = new Machine();
		machine.init();
		
		while(true) {
			machine.show("Please input your command.");
			
			String userInput = br.readLine();
			if(userInput == null || userInput.length() == 0) continue;
			
			String command = userInput.substring(0, 1).trim();			
			if("M".equals(command)){						/* deposite money*/
				String moneyInput = userInput.substring(2);
				double inputAmount = Double.parseDouble(moneyInput);								
				machine.depositeMoney(inputAmount);						
			} else if("I".equals(command)){					/* select item*/
				String itemCode = userInput.substring(2);
				machine.selectItem(itemCode);
			} else if("V".equals(command)){					/* vend */
				machine.vend();
			} else if("c".equals(command)){					
				machine.takeChange();
			} else if("i".equals(command)){	
				machine.takeItem();
			} else if("C".equals(command)){	
				machine.cancelPurchase();
			} else if("d".equals(command)){	
				machine.takeDepositeMoney();
			} else if("e".equals(command)){	
				machine.exit();
			}
			
			machine.showStatus();
		}
	}

}
