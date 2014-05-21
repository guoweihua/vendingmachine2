package machine;

import java.util.LinkedList;

public interface ItemBin {

	public LinkedList<Item> listItems();
	
	public void addItem(Item item);
}
