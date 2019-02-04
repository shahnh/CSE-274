import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Your implementation of the LookupInterface.  The only public methods
 * in this class should be the ones that implement the interface.  You
 * should write as many other private methods as needed.  Of course, you
 * should also have a public constructor.
 * 
 * @author Nishil Shah
 */


public class StudentLookup implements LookupInterface {
	boolean isSorted = true;
	Map<String, Integer> students;
	ArrayList<Node> nodeList;
	int size = 0;
	public StudentLookup() {
		students = new Map();
		nodeList = new ArrayList<>();
	}

	@Override
	public void addString(int amount, String s) {
		isSorted = false;
		Node n = new Node(s, amount);
		if(students.getValue(s) == null) {
			students.add(s, amount);
//			if(nodeList.get(0).getKey().compareTo(s) == 0) {
//				nodeList.add(0, new Node(s, amount));
//				return;
//			}
//			else
//				nodeList.add(new Node(s, amount));
//				size ++;
		}
		else {
			students.add(s, students.getValue(s) + amount);
//			int i = nodeList.indexOf(new Node(s, amount));
//			int v = nodeList.get(i).getValue()+ amount;
//			nodeList.remove(i);
//			nodeList.add(new Node(s, v));
		}
		
		if(nodeList.size() == 0) {
			nodeList.add(n);
			size++;
			return;
		}
		else if(!nodeList.contains(n)) {
			if(n.getKey().compareTo(nodeList.get(0).getKey()) < 0 ){
				nodeList.add(0, n);
			}
			else
				nodeList.add(n);
			size++;
		}
		else {
			int i = nodeList.indexOf(n);
			int v = nodeList.get(i).getValue()+ amount;
			Node newNode = new Node (s, v);
			nodeList.set(i, newNode);
			return;
		}
		
		
	}

	@Override
	public int lookupCount(String s) {
		if(students.getValue(s) != null)
			return students.getValue(s);
		return 0;
	}

	@Override
	public String lookupPopularity(int n) {
		Node[] node = nodeList.toArray(new Node[nodeList.size()]);
		if(!isSorted) {
			HeapSort sortArray = new HeapSort();
//			QuickSort sortArray = new QuickSort();
//			MergeSort sortArray = new MergeSort();
//			sortArray.sort(node, 0, size-1);
			sortArray.sort(node);
//			sortArray.sort(node, 0, size-1);
		}
		return node[n].getKey();
	}

	@Override
	public int numEntries() {
		return size;
	}

//	private ArrayList<Node> sort() {
//		Collections.sort(nodeList, Node.nodeKeyComp);
//		//		Collections.sort(nodeList, Node.nodeValueComp);
//		return nodeList;
//	}

}

class Node {
	private String key;
	private int value;
	public Node(String data, int value) {
		this.key = data;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public int getValue() {
		return value;
	}


	public static Comparator<Node> nodeValueComp = new Comparator<Node>() {
		@Override
		public int compare(Node a, Node b) {
			return (b.value < a.value ? -1 :                     
				(b.value == a.value ? 0 : 1)); 
		}
	};

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}


