package machine;

import java.util.HashMap;
import java.util.Map;

public class ItemHandler {
	private Map<String, ItemInventory> itemInventory = new HashMap<String, ItemInventory>();
	
	public Item vendItem(String itemCode){
		if(!isItemExist(itemCode)) return null;
		
		ItemInventory itemInv = itemInventory.get(itemCode);		
		itemInv.setQuantity(  itemInv.getQuantity() - 1);
		return itemInv.getItem();
	}
	
	public boolean isItemCodeValid(String itemCode) {
		return itemInventory.containsKey(itemCode);
	}
	
	public boolean isItemExist(String itemCode) {
		ItemInventory itemInv = itemInventory.get(itemCode);
		if(itemInv == null || itemInv.getQuantity() <= 0) return false;
		else return true;		
	}
	
	public Item getItemByCode(String itemCode){
		ItemInventory itemInv = itemInventory.get(itemCode);
		return itemInv.getItem();
	}

	public double getItemPriceByCode(String itemCode){
		if(!isItemCodeValid(itemCode)) return 0.0;
		
		Item item = getItemByCode(itemCode);
		return item.getPrice();
	}
	
	public void addItem(Item item, int quantity) {
		String itemCode = item.getName();
		if(isItemCodeValid(itemCode)) {
			ItemInventory itemInv = itemInventory.get(itemCode);
			itemInv.addQuantity(quantity);
		} else {
			ItemInventory itemInv = new ItemInventory(item, quantity);
			itemInventory.put(itemCode, itemInv);
		}
	}

	@Override
	public String toString() {
		return "ItemHandler [itemInventory=" + itemInventory + "]";
	}
	
}
