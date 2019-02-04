
/**
 * An interface that describes the operations of a container of objects
 *
 * @author Manar Mohamed & Md Osman Gani
 */
public interface ContainerInterface<T> {
	
	/**
	 * Returns the number of elements in this container.
	 * 
	 * @return - The number of elements in this container.
	 */
	public int size();

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this list contains no elements, false otherwise.
	 */
	public boolean isEmpty();

	
	/**
	 * Returns the index of the first occurrence of the specified element in this container, or -1 if this container does not contain the element. 
	 * 
	 * @param newObject - element to search for.
	 * 
	 * @return the index of the first occurrence of the specified element in this list, or -1 if this container does not contain the element.
	 */
	public int indexOf(T anObject);
	
	/**
	 * Appends the specified element to the end of this container.
	 * 
	 * @param newObject - element to be appended to this list.
	 * 
	 * @return True if the addition is successful, false otherwise.
	 */
	public boolean add(T newObject);

	/**
	 * Removes the first occurrence of the specified element from this list, if it is present. 
	 * If the list does not contain the element, it is unchanged. 
	 *  
	 * @param anObject - element to be removed from this list, if present.
	 * 
	 * @return true the element was removed from the list, false otherwise.
	 */
	public boolean remove(T anObject);

	/**
	 * Returns true if this container contains the specified element. 
	 * 
	 * @param anObject - element whose presence in this list is to be tested
	 * @return true if this list contained the specified element, false otherwise.
	 */
	public boolean contains(T anObject);
	
}
