package machine;

public class Candy implements Item {
    public static String name = "candy";
    public static double price = 2.0;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
