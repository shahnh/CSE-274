/**
 * A class that implements the ADT list by using a chain of linked nodes that
 * has a head reference.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry MODIFIED BY NORM KRUMPE
 * @version 4.0
 */
public class LListTail<T> implements ListInterface<T> {
	private Node lastNode; // Reference to first node of chain
	private int numberOfEntries;

	public LListTail() {
		initializeDataFields();
	} // end default constructor

	public void clear() {
		initializeDataFields();
	} // end clear

	public void add(T newEntry) // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			lastNode = newNode;
			lastNode.setNextNode(lastNode);
		}
			
		else // Add to end of non-empty list
		{
			newNode = new Node(newEntry, lastNode.getNextNode());
			lastNode.setNextNode(newNode);
		} // end if

		numberOfEntries++;
	} // end add

	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			Node newNode = new Node(newEntry);
			
			if(newPosition == 1 && numberOfEntries == 0) {
				lastNode = newNode;
				lastNode.setNextNode(lastNode);
			}
			else if (newPosition == 1) // Case 1
			{
				newNode = new Node(newEntry, lastNode.getNextNode());
				lastNode.setNextNode(newNode);
			} else if(newPosition == numberOfEntries) {
				newNode.setNextNode(lastNode.getNextNode());
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			}
			else // Case 2: list is not empty
			{ // and newPosition > 1
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end if

			numberOfEntries++;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	} // end add

	public T remove(int givenPosition) {
		T result = null; // Return value

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {

			if (givenPosition == 1) // Case 1: Remove first entry
			{
				result = lastNode.getNextNode().getData(); // Save entry to be removed
				lastNode.setNextNode(lastNode.getNextNode().getNextNode()); // Remove entry
			}
			else if(givenPosition == numberOfEntries) {
				result = lastNode.getData();
				boolean n = true;
				Node temp = lastNode;
				while(n) {
					if(temp.getData().equals(lastNode.getData())) {
						n = false;
					}
					else {
						temp.setNextNode(temp.getNextNode());
					}
					result = lastNode.getData();
					temp.setNextNode(lastNode.getNextNode());
					lastNode = temp;
				}
			}
			else if(numberOfEntries == 1) {
				result  = lastNode.getData();
				lastNode = null;
			}
			else // Case 2: Not first entry
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData(); // Save entry to be removed
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter); // Remove entry
			} // end if
			numberOfEntries--; // Update count
			return result; // Return removed entry
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	} // end remove

	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			return getNodeAt(givenPosition).getData();
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	} // end getEntry

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = numberOfEntries-1;
		Node currentNode = lastNode;
		result[0] = currentNode.getData();
		currentNode = currentNode.getNextNode();
		while ((index > 0) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index--;
		} // end while
		return result;
	} // end toArray

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = lastNode.getNextNode();
		int counter = 0;

		while (!found && counter <= numberOfEntries) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
			counter++;
		} // end while
		
		
		return found;
	} // end contains

	public int getLength() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		lastNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		Node currentNode = lastNode;
		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		return currentNode;
	} // end getNodeAt

	private class Node {
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LList
