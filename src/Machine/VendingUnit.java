package machine;

public class VendingUnit implements Vending{
	private ItemHandler itemHandler;
	private MoneyHandler moneyHandler;
	
	public VendingUnit() {
		itemHandler = new ItemHandler();
		moneyHandler = new MoneyHandler();
	}
	
	@Override
	public void vending(VendingIO vendingIO) {
		
		if(!validateVending(vendingIO)) {
			noVending(vendingIO);
		} else {
			doVending(vendingIO);			
		}		
	}
    
	private void doVending(VendingIO vendingIO) {
		String itemCode = vendingIO.getItemCode();
		
		/* get item from inventory */
		Item item = itemHandler.vendItem(itemCode);
		vendingIO.setItem(item);		

		/* take money and get Change */
		double itemPrice = itemHandler.getItemPriceByCode(itemCode);
		vendingIO.setChange(moneyHandler.buy(vendingIO.getInputMoney(), itemPrice));
		
	}
	
	private void noVending(VendingIO vendingIO) {
		vendingIO.setItem(null);
		vendingIO.setChange(vendingIO.getInputMoney());		
	}
	
	/** check business logic 
	 *	1. we vender only certain items we list
	 *  2. we vender items we have in this machine
	 *  3. we vender when you pay enough money for the item you pick
	 **/
	private boolean validateVending(VendingIO vendingIO) {
		String itemCode = vendingIO.getItemCode();
		
		/* check item code is valid */
		if(!itemHandler.isItemCodeValid(itemCode)) {
			vendingIO.setMessage("Item Code not Support");
			vendingIO.setStatus("ItemCodeNotSupport");
			return false;
		}
		
		/* check item exit*/
		if(!itemHandler.isItemExist(itemCode)) {
			vendingIO.setMessage("Out Of Item");
			vendingIO.setStatus("OutOfItem");
			return false;
		}
		
		/* check money enough for the item*/
		double inputMoney = vendingIO.getInputMoney();
		double itemPrice = itemHandler.getItemPriceByCode(itemCode);
		if(!moneyHandler.isEnoughMoneyForItem(inputMoney, itemPrice)) {
			vendingIO.setMessage("Money Not Enough For Item");
			vendingIO.setStatus("MoneyNotEnoughForItem");
			return false;
		}
		
		/* validation success*/
		vendingIO.setMessage("Transaction Validated");
		vendingIO.setStatus("Validated");
		return true;
	}

	public void addItem(Item item, int quantity){
		itemHandler.addItem(item, quantity);
	}

	@Override
	public String toString() {
		return "VendingUnit [itemHandler=" + itemHandler + ", moneyHandler="
				+ moneyHandler + "]";
	}
	
}
