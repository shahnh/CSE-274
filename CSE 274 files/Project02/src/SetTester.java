import java.util.Arrays;
/**
 * 
 * @author Nishil Shah
 * CSE 274 F
 * Project02 SetTester.java
 */
public class SetTester {
	public static void main(String[] args) {
		ResizableArraySet bag1 = new ResizableArraySet();
		System.out.println("Calling the remove method!\nnull? " + bag1.remove());
		System.out.println("Calling isEmpty method on bag1:\nTrue? " +  bag1.isEmpty());
		System.out.println("Adding number 4, 9, and 2 in the bag1!");
		bag1.add(4);
		bag1.add(9);
		bag1.add(2);
		System.out.println("Calling the getSize method!\n3? " + bag1.getSize());
		System.out.println("This is in bag1: " + Arrays.toString(bag1.toArray()));
		System.out.println("Adding number 5 and 0 in the bag1!");
		bag1.add(5);
		bag1.add(0);
		System.out.println("Now the size of the bag1 is 5? " + bag1.getSize());
		System.out.println("This is bag1: " + bag1);
		System.out.println("Calling isEmpty method on bag1:\nFalse? " +  bag1.isEmpty());
		System.out.println("Checking if bag1 contains number 10\nfalse? " + bag1.contains(10));
		ResizableArraySet bag2 = new ResizableArraySet(1);
		System.out.println("Adding number 10, 0, 9, 1, 3, and 8 in the bag2:");
		bag2.add(10);
		bag2.add(0);
		bag2.add(9);
		bag2.add(1);
		bag2.add(3);
		bag2.add(8);
		System.out.println("This is bag2: " + bag2);
		System.out.println("Calling remove method on bag2 to remove number 8!\nTrue? " + bag2.remove(8) );
		System.out.println("This is bag2: " + bag2);
		System.out.println("Calling remove method on bag2 to remove any number!\nShould remove 3? " + bag2.remove());
		System.out.println("This is bag2: " + Arrays.toString(bag2.toArray()));
		System.out.println("Calling intersection method on bag1 taking in bag2:\n0 and 9? " + bag1.intersection(bag2));
		System.out.println("This is Union Set: " + bag2.union(bag1));
		System.out.println("Calling clear method on bag1");
		bag1.clear();
		System.out.println("Bag1 should not have any number: " + bag1);
		System.out.println("This is bag2: " + bag2);
	}
}