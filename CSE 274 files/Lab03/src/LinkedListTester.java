
public class LinkedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("========================================");
		System.out.println("Created a linked list:");
		// Create a linked list object
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());
		
		
		
		System.out.println("========================================");
		System.out.println("Add 5 to the head:");
		// Add 5 to the head
		linkedList.addToHead(5);
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());
		
		System.out.println("========================================");
		System.out.println("Remove the first element from the list:");
		// Add 5 to the head
		linkedList.removeFirst();
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());
		
		System.out.println("========================================");
		System.out.println("Check remove the first element from an empty list:");
		// Add 5 to the head
		linkedList.removeFirst();
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());
		
		System.out.println("========================================");
		System.out.println("Check remove the last element from an empty list:");
		// Add 5 to the head
		linkedList.removeFirst();
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());
		

		System.out.println("========================================");
		System.out.println("Add 9 and 1 to the head:");
		// Add 9 and 1 to the head one after another
		linkedList.addToHead(9);
		linkedList.addToHead(1);

		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());
		
		System.out.println("========================================");
		// List contains value 9?
		System.out.print("Contains the value 9? ");
		System.out.println(linkedList.contains(9));

		// List contains value 4?
		System.out.print("Contains the value 4? ");
		System.out.println(linkedList.contains(4));
		
		
		System.out.println("========================================");
		System.out.println("Add 3 to the tail:");
		// Add 3 to the tail
		linkedList.addToTail(3);
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());

		
		System.out.println("========================================");
		System.out.println("Add 8 and 2 to the tail:");
		// Add 8 and 2 to the head one after another
		linkedList.addToTail(8);
		linkedList.addToTail(2);

		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());

		System.out.println("========================================");
		// List contains value 2?
		System.out.print("Contains the value 2? ");
		System.out.println(linkedList.contains(2));

		// List contains value 4?
		System.out.print("Contains the value 7? ");
		System.out.println(linkedList.contains(7));
		
		System.out.println("========================================");
		System.out.println("Remove first node from the list:");
		// Remove first node
		linkedList.removeFirst();
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());		
		
		System.out.println("========================================");

		System.out.print("What is the last node? ");
		System.out.println(linkedList.lastNode().getData());
		// Remove last node
		System.out.println("Remove last node from the list:");

		linkedList.removeLast();
		// Print the content of the list
		System.out.print("Content of the list:");
		System.out.println(linkedList.toString());
		// Print the number of items in the list
		System.out.print("Number of items in the list:");
		System.out.println(linkedList.countNodes());		
		
				
	}

}
