import java.util.Arrays;

public class SetTester {
	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("Created a linked list:");
		// Create a linked list object
		SortedSet fruits = new SortedSet();
		
		fruits.add("Watermellon");
		fruits.add("Apple");
		fruits.add("Banana");
		
		fruits.add("Grapes");
		fruits.add("cat");
		
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(Arrays.toString(fruits.toArray()));
		
		// Print the number of items in the list
		System.out.print("Number of items in the list: ");
		System.out.println(fruits.getCurrentSize());
		
		System.out.println(fruits.remove());
		System.out.println(fruits.getCurrentSize());
		System.out.println(fruits);
		System.out.println(fruits.remove("Banana"));
		System.out.println(fruits);
		
		System.out.println(fruits.getCurrentSize());
		System.out.println(fruits);
		System.out.println(fruits.contains("Grap"));
		
		
	}

}
