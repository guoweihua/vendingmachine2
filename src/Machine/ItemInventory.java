package machine;

public class ItemInventory {
	private Item item;
	private int quantity;
	
	public ItemInventory(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addQuantity(int quantity){
		this.quantity += quantity;
	}
	
	public void removeQuantity(int quantity){
		this.quantity -= quantity;
	}

	@Override
	public String toString() {
		return "ItemInventory [item=" + item + ", quantity=" + quantity + "]";
	}
	
}
