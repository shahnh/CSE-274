
public class MySortedLinkedList {
	Node removed = new Node(anEntry);

	if(isEmpty()) 
		return false;

	if(this.contains(anEntry) == false)
		return false;

	else if(this.getCurrentSize() == 1) {
		head = null;
		size--;
		return true;
	}

	else { 
		Node first = head;
		Node second = head.next;

		int i = 0;
		Node found = head;
		while(i < size) {
			if(found.data.equals(anEntry)) {
				break;
			}
			first = second;
			second = second.next;
			i++;
		}

		removed.next = null;
		first.next.next = second;
		size--;
		return true;
	}
	
	
	//	public boolean remove(String anEntry) {
	//		anEntry = upperCase(anEntry);
	//		@SuppressWarnings("rawtypes")
	//		Node p = head;
	//		while(p != null) {
	//			if(p.getData().equals(anEntry)) {
	//				p.setData(head.getData());
	//				noOfEle--;
	//				return true;
	//			}
	//			p = p.getNext();
	//		}
	//		return false;
	//	}
//	
	
}
