import java.util.ArrayList;
import java.util.Collections;

/**
 * Your implementation of the LookupInterface.  The only public methods
 * in this class should be the ones that implement the interface.  You
 * should write as many other private methods as needed.  Of course, you
 * should also have a public constructor.
 * 
 * @author Nishil Shah
 */

public class StudentLookup implements LookupInterface {
	ArrayList<Hash> students;
	int size = 0;
	public StudentLookup() {
		students = new ArrayList<>();
	}

	@Override
	public void addString(int amount, String s) {
		Hash h = new Hash(s, amount);
		if(students.size() == 0) {
			students.add(h);
			size++;
			return;
		}
		else if(!students.contains(h)) {
			if(students.get(0).key.compareTo(h.key) > 0) {
				students.add(0, h);
			}
			else
				students.add(h);
			size++;
		}
		else {
			int i = students.indexOf(h);
			int v = students.get(i).getValue()+ amount;
			students.set(i, new Hash(s, v));
			return;
		}
	}

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
		ArrayList<Hash> sortedTerms = sort();
		return sortedTerms.get(n).getKey();
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


