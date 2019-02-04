import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Your implementation of the LookupInterface.  The only public methods
 * in this class should be the ones that implement the interface.  You
 * should write as many other private methods as needed.  Of course, you
 * should also have a public constructor.
 * 
 * @author // TODO: Pushti Mody
 */


public class StudentLookup implements LookupInterface {
	ArrayList<Point> terms; //Holds unique instances of words stored as Points which hold the word and its popularity

	public StudentLookup() {
		terms = new ArrayList<>(); // Initialize term
	}

	@Override
	public void addString(int amount, String s) {
		//Case 0: terms is empty
		Point p = new Point(amount, s);
		if(terms.size() == 0) {
			terms.add(p);
			return;
		}
		//Case 1: terms doesn't have this Point
		else if(findWord(s) == -1) {
			if(terms.get(0).data.compareTo(p.data) > 0) { //If the current Point comes before the one to be added, place one to be added after
				terms.add(0, p);
			}
			else
				terms.add(p);
		}
		else { //Case 2: terms contains this Point

			int newPop = terms.get(getIndexOf(s)).pop + amount;
			update(getIndexOf(s), s, newPop);
			return;
		}

	}
	private int getIndexOf(String search) {
		for(int i = 0; i < terms.size(); i++) {
			if(terms.get(i).data.equals(search)) { //If term is found at this index, return the index
				return i;
			}
		}
		return -1;
	}

	private void update(int index, String word, int pop) {
		Point p = new Point(pop, word); // Create Point out of parameters
		terms.set(index, p); //Assign new Point to pre-existing index to update/replace current Point at that location
	}

	/*
	 * findWord searches for a word in the ArrayList term then returns the word's popularity if the word is found
	 */
	private int findWord(String s) {
		for(int i = 0; i < terms.size(); i++) {
			if(terms.get(i).data.equals(s)) { //Find a word via loop then return its popularity
				return terms.get(i).pop;
			}
		}
		return -1;
	}

	@Override
	public int lookupCount(String s) {
		if(findWord(s) == -1)
			return 0;
		else
			return findWord(s);
	}

	@Override
	public String lookupPopularity(int n) {
		ArrayList<Point> sortedTerms = sort();
		return sortedTerms.get(n).data;
	}

	@Override
	public int numEntries() {
		return terms.size();
	}

	/*
	 * Sorts the ArrayList term based on a Point's popularity
	 */
	private ArrayList<Point> sort() {
		Collections.sort(terms, Point.popComp);
		return terms;
	}

	/*
	 * Point is a data structure which holds a String data and an associated int pop (popularity)
	 * This Structure also contains a Comparator for sorting, and a toString for easy printing
	 */
	private static class Point{
		int pop; // The popularity of a word
		String data; // The word contained in the Point

		public Point(int pop, String data) {
			this.pop = pop;
			this.data = data;
		}

		public static Comparator<Point> popComp = new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return (o2.pop < o1.pop ? -1 :                     
					(o2.pop == o1.pop ? 0 : 1)); 
			}
		};
	}

}
