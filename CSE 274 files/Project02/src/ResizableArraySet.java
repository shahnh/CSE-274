import java.util.Arrays;

/**
 * 
 * @author Nishil Shah
 * CSE 274 F
 * Project02 ResiResizableArraySet.java
 */

public class ResizableArraySet implements SetInterface<Integer>{

	private Integer[] bag;
	private int noOfElements;
	private final static int DEF_SIZE = 10;
	private final static int MAX_SIZE = 1000;

	public ResizableArraySet(int size) {
		if(size < MAX_SIZE) {
			bag = new Integer[size];
			noOfElements = 0;
		}
		else
			bag = new Integer[DEF_SIZE];
	}

	public ResizableArraySet() {
		this(DEF_SIZE);
	}

	/**
	 * Gets the current number of entries in this set.
	 *
	 * @return The integer number of entries currently in the set.
	 */
	@Override
	public int getSize() {
		return noOfElements;
	}

	/**
	 * Sees whether this set is empty.
	 *
	 * @return True if the set is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {
		if(noOfElements == 0)
			return true;
		return false;
	}

	/**
	 * Adds a new entry to this set, avoiding duplicates.
	 *
	 * @param newEntry
	 *            The object to be added as a new entry.
	 * @return True if the addition is successful, or false if the item 
already
	 *         is in the set.
	 */
	@Override
	public boolean add(Integer newEntry) {
		if(!contains(newEntry)) {
			if(noOfElements == bag.length) {
				int newSize = 2 * bag.length;
				bag = Arrays.copyOf(bag, newSize);
			}
			else if(noOfElements < (bag.length)/2) {
				int newSize = (bag.length / 2);
				bag = Arrays.copyOf(bag, newSize);
			}
			bag[noOfElements] = (Integer) newEntry;
			noOfElements++;
			return true;
		}
		return false;
	}

	/**
	 * Removes a specific entry from this set, if possible.
	 *
	 * @param anEntry
	 *            The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	@Override
	public boolean remove(Integer anEntry) {
		for(int i = 0; i < noOfElements; i++) {
			if(bag[i].equals(anEntry)) {
				bag[i] = bag[noOfElements-1];
				bag[noOfElements-1] = null;
				noOfElements--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes one unspecified entry from this set, if possible.
	 *
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	@Override
	public Integer remove() {
		if(!isEmpty()) {
			Integer results = bag[noOfElements-1];
			bag[noOfElements-1] = null;
			noOfElements--;
			return results;
		}		
		return null;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
		while(!isEmpty())
			remove();
	}

	/**
	 * Tests whether this set contains a given entry.
	 *
	 * @param anEntry
	 *            The entry to locate.
	 * @return True if the set contains anEntry, or false if not.
	 */
	@Override
	public boolean contains(Integer anEntry) {
		for(int i = 0; i<noOfElements; i++) {
			if(bag[i].equals(anEntry))
				return true;
		}
		return false;
	}

	/**
	 * Computes the union of this set with a given set
	 *
	 * @param anotherSet
	 *            another set
	 * @return the union of this set with anotherSet
	 */
	@Override
	public SetInterface<Integer> union(SetInterface<Integer> anotherSet) {
		SetInterface<Integer> copy =  new ResizableArraySet();
		Integer[] copyNum = (Integer[]) anotherSet.toArray();
		for (Integer i: copyNum)
			copy.add(i);
		for(int i = 0; i<noOfElements; i++) {
			if((copy.contains(bag[i])))
				copy.remove(bag[i]);
			copy.add(bag[i]);
		}
		return copy;
	}

	/**
	 * Computes the intersection of this set with a given set
	 *
	 * @param anotherSet
	 *            another set
	 * @return the intersection of this set with anotherSet
	 */
	@Override
	public SetInterface<Integer> intersection(SetInterface<Integer> anotherSet) {
		SetInterface<Integer> answers = new ResizableArraySet(DEF_SIZE);
		for(int i = 0; i<noOfElements; i++) {
			if((anotherSet.contains(bag[i])))
				answers.add(bag[i]);
		}
		return answers;
	}

	/**
	 * Retrieves all entries that are in this set.
	 *
	 * @return A newly allocated array of all the entries in the set, where the size of the array is equal to the number of entries in the set.
	 */
	@Override
	public Integer[] toArray() {
		Integer[] results = new Integer[noOfElements];
		for(int i = 0; i <noOfElements; i++) {
			results[i] = bag[i];
		}
		return results;
	}

	/**
	 * toString method to the array in format of String.
	 */
	@Override
	public String toString() {
		Integer[] copy = toArray();
		String s = "[";
		for(int i = 0; i<copy.length; i++) {
			s += copy[i];
			if(i != copy.length-1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
}