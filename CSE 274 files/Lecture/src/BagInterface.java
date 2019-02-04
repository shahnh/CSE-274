
public interface BagInterface<T> {
	
	public boolean add(T item);
	public int count();
	public T remove();
	public boolean contains(T item);
	public void removeAll();
	public boolean remove(T item);
	public T[] toArray();
	

}
