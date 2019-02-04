/**
 * A linked-node implementation of the Set ADT in which elements of the set
 * are always sorted (in this case, lexicographically, which is a fancy
 * way of saying "alphabetically").  Note that the String class has a compareTo
 * method which you should be using to assist you in keeping the set sorted.
 * 
 */

/**
 * 
 * @author Nishil Shah
 * CSE 274 F
 * Project03 SortedSet.java
 *
 */
public class SortedSet implements SetInterface<String> {
	@SuppressWarnings("rawtypes")
	private Node head;
	private int noOfEle;

	/** Gets the current number of entries in this set.
    @return  The integer number of entries currently in the set. */
	@Override
	public int getCurrentSize() {
		return noOfEle;
	}

	/** Sees whether this set is empty.
    @return  True if the set is empty, or false if not. */
	@Override
	public boolean isEmpty() {
		return noOfEle == 0;
	}

	/** Adds a new entry to this set, avoiding duplicates.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or
             false if the item already is in the set. */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(String newEntry) {
		newEntry = upperCase(newEntry);
		if(contains(newEntry))
			return false;
		Node<String> newNode = new Node<String>(newEntry);
		if(head == null) {
			head = newNode;
		}

		else if (newEntry.compareTo((String) head.getData()) < 0){
			newNode.setNext(head);
			
			head = newNode;
		}

		else {
			Node first = head;
			Node last = head.getNext();
			while(last != null) {
				if(newEntry.compareTo((String) last.getData()) < 0)
					break;
				first = last;
				last = last.getNext();
			}
			newNode.setNext(first.getNext());
			first.setNext(newNode);
		}
		noOfEle++;
		return true;
	}

	/** Removes a specific entry from this set, if possible.
    @param anEntry  The entry to be removed.
   @return  True if the removal was successful, or false if not. */
	@Override
	public boolean remove(String anEntry) {
		anEntry = upperCase(anEntry);
		@SuppressWarnings("rawtypes")
		Node p = head;

		if(head == null)
			return false;
		else if(head.getData().equals(anEntry)) {
			head = head.getNext();
			noOfEle--;
			return true;
		}

		else {
			while(p != null) {
				if(p.getNext().getData().equals(anEntry)) {
					p.setNext(p.getNext().getNext());
					noOfEle--;
					return true;
				}
				p = p.getNext();
			}
			return false;
		}
	}

	/** Removes one unspecified entry from this set, if possible.
    @return  Either the removed entry, if the removal
             was successful, or null. */
	@Override
	public String remove() {
		if(head == null)
			return null;
		String temp = (String) head.getData();
		head = head.getNext();
		noOfEle--;
		return temp;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
		while(!isEmpty())
			remove();
	}

	/** Tests whether this set contains a given entry.
    @param anEntry  The entry to locate.
    @return  True if the set contains anEntry, or false if not. */
	@Override
	public boolean contains(String anEntry) {
		anEntry = upperCase(anEntry);
		@SuppressWarnings("rawtypes")
		Node p = head;
		while(p != null) {
			if(p.getData().equals(anEntry))
				return true;
			p = p.getNext();	
		}
		return false;
	}

	/*
	 * returns a string representation of the items in the bag,
	 * specifically a space separated list of the strings, enclosed
	 * in square brackets [].  For example, if the set contained
	 * cat, dog, then this should return "[cat dog]".  If the
	 * set were empty, then this should return "[]".
	 */
	@Override
	public String toString() {
		Node<String> p = head;
		String s = "[";
		while(p != null) {
			s += p.getData();
			if(p.getNext() != null) {
				s += ", ";
			}
			p = p.getNext();
		}
		s += "]";
		return s;
	}

	/** Retrieves all entries that are in this set.
	 @return  A newly allocated array of all the entries in the set. */
	@Override
	public String[] toArray() {
		@SuppressWarnings("unchecked")
		String[] arr = new String[noOfEle];
		int count = 0;
		Node p = head;
		while(p != null) {
			arr[count] = (String) p.getData();
			count++;
			p = p.getNext();
		}
		return arr;
	}

	private String upperCase(String id) {
		id = id.trim();
		String cap = id.substring(0, 1).toUpperCase() + id.substring(1).toLowerCase();
		return cap;
	}
}

