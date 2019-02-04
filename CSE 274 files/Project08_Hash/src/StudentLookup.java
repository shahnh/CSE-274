import java.util.ArrayList;
import java.util.Collections;


public class StudentLookup implements LookupInterface {
	ArrayList<Hash> students; //Holds unique instances of words stored as Points which hold the word and its popularity
	int size = 0;
	public StudentLookup() {
		students = new ArrayList<>(); // Initialize term
	}

	@Override
	public void addString(int amount, String s) {
		//Case 0: terms is empty
		Hash h = new Hash(s, amount);
		if(students.size() == 0) {
			students.add(h);
			size++;
			return;
		}
		//Case 1: terms doesn't have this Point
		else if(!students.contains(h)) {
			if(students.get(0).key.compareTo(h.key) > 0) { //If the current Point comes before the one to be added, place one to be added after
				students.add(0, h);
			}
			else
				students.add(h);
			size++;
		}
		else { //Case 2: terms contains this Point

			int i = students.indexOf(h);
			int v = students.get(i).getValue()+ amount;
			students.set(i, new Hash(s, v));
			return;
		}
	}
	//	private int getIndexOf(String search) {
	//		for(int i = 0; i < students.size(); i++) {
	//			if(students.get(i).data.equals(search)) { //If term is found at this index, return the index
	//				return i;
	//			}
	//		}
	//		return -1;
	//	}

	//	private void update(int index, String word, int pop) {
	//		Point p = new Point(pop, word); // Create Point out of parameters
	//		students.set(index, p); //Assign new Point to pre-existing index to update/replace current Point at that location
	//	}

	/*
	 * findWord searches for a word in the ArrayList term then returns the word's popularity if the word is found
	 */
	//	private int findWord(String s) {
	//		for(int i = 0; i < students.size(); i++) {
	//			if(students.get(i).data.equals(s)) { //Find a word via loop then return its popularity
	//				return students.get(i).pop;
	//			}
	//		}
	//		return -1;
	//	}

	@Override
	public int lookupCount(String s) {
		if(!students.contains(new Hash(s, 0)))
			return 0;
		else {
			int i = students.indexOf(new Hash(s,0));
			return students.get(i).getValue();
		}
	}


	@Override
	public String lookupPopularity(int n) {
		System.out.println(students);
		
		Hash[] hash = students.toArray(new Hash[students.size()]);
		HeapSort sortArray = new HeapSort();
		int l = hash.length-1;
		sortArray.sort(hash);
		//, 0, l
		
		return hash[n].getKey();
		
		//ArrayList<Hash> sortedTerms = sort();
//		return sortedTerms.get(n).getKey();
	}

	@Override
	public int numEntries() {
		return size;
	}
	
	private ArrayList<Hash> sort() {
	Collections.sort(students, Hash.hashValueComp);
	return students;
}
}


