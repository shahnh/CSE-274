import java.util.HashMap;
import java.util.HashSet;

class LinkedBag<T> implements BagInterfaceExtension<T>{

	private class Node{
		private T data;
		private Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;

	private int noOfEle;	

	@Override
	public int getCurrentSize() {
		return noOfEle;
	}



	@Override
	public boolean isEmpty() {
		return noOfEle == 0;
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
				head = head.next;
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

	@Override
	public void removeDuplicates() {
		if(head == null)
			return;
		HashSet<T> s = new HashSet<>();
		Node currentNode = head;
		while(currentNode != null) {
			s.add(currentNode.data);
			currentNode = currentNode.next;
		}
		head = null;
		noOfEle= 0;
		for (T element: s) {
			add(element);
		}
	}



	@Override
	public boolean equals(LinkedBag<T> aBag) {
		HashMap<T, Integer> storage1 = new HashMap<>();
		HashMap<T, Integer> storage2 = new HashMap<>();
		Node n1 = aBag.head;
		Node n2 = head;
		while(n1 != null) {
			if(storage1.containsKey(n1.data))
				storage1.put(n1.data, 1+storage1.get(n1.data));
			else
				storage1.put(n1.data, 1);
			n1 = n1.next;
		}
		while(n2 != null) {
			if(storage2.containsKey(n2.data))
				storage2.put(n2.data, 1+storage2.get(n2.data));
			else
				storage2.put(n2.data, 1);
			n2 = n2.next;
		}
		for(T key: storage2.keySet()) {
			if(storage1.get(key) != storage2.get(key))
				return false;
		}
		if(storage1.keySet().size() != storage2.keySet().size())
			return false;
		return true;
	}

}
