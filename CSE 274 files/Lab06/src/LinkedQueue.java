public class LinkedQueue<T> implements QueueInterface<T>{
	
	private class Node{
		private T data;
		private Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	Node frontNode, backNode;

	public LinkedQueue() {
		frontNode = null;
		backNode = null;
	}
	
	@Override
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if(isEmpty()) {
			frontNode = newNode;
			backNode = newNode;
		}
		else {
			backNode.next = newNode;
			backNode = newNode;
		}
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new EmptyQueueException();
		T data = frontNode.data;
		frontNode = frontNode.next;
		if(frontNode == null)
			backNode = null;
		return data;
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		return frontNode.data;
	}

	@Override
	public boolean isEmpty() {
		return frontNode == null;
	}

	@Override
	public void clear() {
		frontNode = null;
	}

}
