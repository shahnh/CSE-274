public interface QueueInterface<T> {
	
	/**
	 * Adds a new entry to the back of the queue
	 * @param newEntry is the new entry
	 */
	public void enqueue(T newEntry);
	
	/**
	 * Removes and returns the entry at the front of the queue
	 * @return Return the queue's front entry. Throws an 
	 */
	public T dequeue();
	public T getFront();
	public boolean isEmpty();
	public void clear();	
}
