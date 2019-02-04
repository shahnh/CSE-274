
public class LinkedListBag<T> implements BagInterface<T>{

	private class Node{
		private T data;
		private Node next;

		public Node(T data, LinkedListBag<T>.Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private int noOfEle;

	public LinkedListBag() {
		head = null;
		noOfEle = 0;
	}

	@Override
	public int getCurrentSize() {
		return noOfEle;
	}

	@Override
	public boolean isEmpty() {
		return noOfEle == 0; //or head == null;
	}

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry, head);
		head = newNode;
		noOfEle++;
		return true;
	}

	@Override
	public T remove() {
		if(head == null)
			return null;
		T temp = head.data;
		head = head.next;
		noOfEle--;
		return temp;
	}

	@Override
	public boolean remove(T anEntry) {
		Node p = head;
		while(p != null) {
			if(p.data.equals(anEntry)) {
				p.data = head.data;
				noOfEle--;
				return true;
			}
			p = p.next;
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		noOfEle = 0;

		//		while(!isEmpty())
		//			remove();

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		Node p = head;
		while(p != null) {
			if(p.data.equals(anEntry))
				count++;
			p = p.next;	
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		Node p = head;
		while(p != null) {
			if(p.data.equals(anEntry))
				return true;
			p = p.next;	
		}
		return false;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) new Object[noOfEle];
		int count = 0;
		Node p = head;
		while(p != null) {
			arr[count] = p.data;
			count++;
			p = p.next;
		}
		return arr;
	}

	T removeTail() {
		if(head == null) return null;
		if(head.next == null) {
			T temp = head.data;
			head = null;
			noOfEle--;
			return temp;
		}
		
		Node p = head, q = head;
		while(p.next != null) {
			q = p;
			p = p.next;
		}
		q.next = null;
		noOfEle--;
		return p.data;
	}	
}
