
public class GroceryItem {
	private String name;
	private double price;


	public static void main(String[] args) {
	GroceryItem apple = new GroceryItem("Apple", 5);
	GroceryItem orange = new GroceryItem("Orange", 4);
	GroceryItem tomato = new GroceryItem("Tomato", 2);
	
	BagInterface<GroceryItem> shoppingCart = new Bag<>();
		shoppingCart.add(apple);
		shoppingCart.add(orange);
		shoppingCart.add(tomato);
		
		double total = 0;
		while(shoppingCart.count() !=0 ) {
			GroceryItem item = shoppingCart.remove();
			total += item.getPrice();
		}
		
	}
	public GroceryItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
