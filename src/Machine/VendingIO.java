package machine;

public class VendingIO {
	private String itemCode;
	private double change;
	private double inputMoney;
	public double getInputMoney() {
		return inputMoney;
	}
	public void setInputMoney(double inputMoney) {
		this.inputMoney = inputMoney;
	}
	private Item   item;
	private String message;
	private String status;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
