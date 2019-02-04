public class LinkedList<T> {

	private Node<T> head;
	private int numOfEle;
	public LinkedList() {
		head = null;
		numOfEle = 0;
	}

	public void addToHead(T value) {
		Node<T> newNode = new Node(value, head);
		head = newNode;
		numOfEle++;
	}

	public void addToTail(T value) {
		Node<T> newNode = new Node(value, null);
		if(head == null)
			head = newNode;
		else {
			Node<T> p = head;
			while(p.getNext() != null)
				p = p.getNext();
			p.setNext(newNode);			
		}
		numOfEle++;
	}

	public Node<T> removeFirst(){
		if(head == null) 
			return null;
		else {
			Node<T> results = head;
			head = head.getNext();
			numOfEle--;
			return results;
		}
	}

	public Node<T>removeLast(){

		if(head == null)
			return null;
		if(head.getNext() == null) {
			Node returnNode = head;
			head = null;
			return returnNode;
		}
		Node p = head; 
		while(p.getNext().getNext()!= null) {
			p = p.getNext();
		}
		Node returnNode = p.getNext();
		p.setNext(null);
		numOfEle--;
		return returnNode;
	}

	public boolean contains(T value) {
		Node<T> p = head;
		while(p != null) {
			if(p.getData().equals(value))
				return true;
			p = p.getNext();	
		}
		return false;
	}

	public Node<T> lastNode() {
		Node<T> p = head;
		Node<T> answers;
		if(head == null)
			return null;

		while(p.getNext() != null) {
			p = p.getNext();	
		}
		answers = p;
		return p;
	}

	public int countNodes() {
		return numOfEle;
	}

	public String toString() {
		Node<T> p = head;
		String s = "[";
		while(p != null) {
			s += p.getData();
			if(p != lastNode()) {
				s += ", ";
			}
			p = p.getNext();
		}
		s += "]";
		return s;
	}
}