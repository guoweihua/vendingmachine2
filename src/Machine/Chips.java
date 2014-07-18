package machine;

public class Chips implements Item {
    public static String name = "chips";
    public static double price = 1.0;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
