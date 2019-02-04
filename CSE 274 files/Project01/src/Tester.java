
/*
 * This is just the beginning of testing.  It does not test all the methods.
 * Feel free to use this in any way you want, or ignore it and create your own tester.
 * Note that if my tester does not compile, it indicates a problem with one
 * of your methods or constructors. 
 * 
 */

import java.util.Arrays;

public class Tester {
	
	public static double calArea(int r){
		assert r >= 0;
		
		double area = 3.14 * r * r;
		
		assert area > 0;
		return area;
		
	}

	public static void main(String[] args) {

		System.out.println("An empty network:");
		PalBook sn = new PalBook(7);
		System.out.println(sn);

		System.out.println("Add Manar and her siblings:");
		boolean result;
		result = sn.addMember("Manar");
		sn.addMember("Manal");
		sn.addMember("Kasem");
		sn.addMember("Majdi");
		sn.addMember("Maher");

		System.out.println(sn);

		System.out.println("So far, there are no pals in the network:");
		String[] palsOfManar = sn.getPals("Manar");
		System.out.println("Manar's pals: " + Arrays.toString(palsOfManar));

		System.out.println("Give Manar a couple pals:");
		sn.makePals("Manar", "Manal");
		sn.makePals("Manar", "Kasem");
		sn.makePals("Manar", "Maher");
		palsOfManar = sn.getPals("Manar");
		System.out.println("Manar's pals: " + Arrays.toString(palsOfManar));
		System.out.println("\nHere's the network so far:");
		System.out.println("Everything should be sorted by name...");
		System.out.println(sn);
		
		System.out.println("Remove Kasem from the network:");
		sn.removeMember("Kasem");
		System.out.println(sn);
		
		System.out.println("Remove Maher from Manar's pals:");
		sn.endPals("Manar", "Maher");
		System.out.println(sn);
		

		System.out.println("\nThere are still some methods to be tested.");
		System.out.println("Also need to test what happens for edge cases...");
		System.out.println("Adding when the network is full");
		System.out.println("Removing a non-existent member");
		System.out.println("Removing when the network is empty");
		System.out.println("Making pals when one or more names is not a member");
		System.out.println("And so on...");

				
		
		
	}

}
