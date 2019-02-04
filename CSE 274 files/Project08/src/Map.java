import java.util.ArrayList;

public class Map<K,V> {
	private ArrayList<Hash<K,V>> storage;
	private int size;
	private int curSize;

	public Map() {
		super();
		this.storage = new ArrayList<>();
		this.size = 10;
		this.curSize = 0;

		for(int i = 0; i < size; i++) {
			storage.add(null);
		}
	}

	public Map(int size) {
		super();
		this.storage = new ArrayList<>();
		this.size = size;
		this.curSize = 0;

		for(int i = 0; i < size; i++) {
			storage.add(null);
		}
	}

	public int getCurSize() {
		return curSize;
	}

	public boolean isEmpty() {
		return curSize == 0;
	}

	public int getHash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % size;
		if(index <0)
			index += size;
		return index;
	}

	public V removeKey(K key) 
	{ 
		int index = getHash(key); 
		Hash<K, V> head = storage.get(index); 

		Hash<K, V> prev = null; 
		while (head != null) {
			if (head.key.equals(key)) {
				break;
			}
			prev = head; 
			head = head.next; 
		}
		if (head == null) {
			return null; 
		}
		curSize--;
		if (prev != null) {
			prev.next = head.next; 
		}
		else {
			storage.set(index, head.next); 
		}
		return head.value; 
	}

	public V getValue(K key) {
		int index = getHash(key); 
		Hash<K, V> head = storage.get(index);

		while (head != null) { 
			if (head.key.equals(key)) {
				return head.value; 
			}
			head = head.next; 
		}
		return null; 
	}

	public void add(K key, V value) {
		int index = getHash(key); 


		Hash<K, V> head = storage.get(index);

		while (head != null) 
		{ 
			if (head.key.equals(key)) 
			{ 
				head.value = value; 
				return; 
			} 
			head = head.next; 
		} 
		curSize++; 
		head = storage.get(index); 
		Hash<K, V> newHash = new Hash<K, V>(key, value); 
		newHash.next = head; 
		storage.set(index, newHash); 

		if ((1.0*curSize)/size >= 0.5) 
		{ 
			ArrayList<Hash<K, V>> temp = storage; 
			storage = new ArrayList<>(); 
			size = 2 * size; 
			curSize = 0; 
			for (int i = 0; i < size; i++) 
				storage.add(null); 

			for (Hash<K, V> headNode : temp) 
			{ 
				while (headNode != null) 
				{ 
					add(headNode.key, headNode.value); 
					headNode = headNode.next; 
				} 
			} 
		} 
	}



	@Override
	public String toString() {
		return "" + storage;
	}

	public boolean containKey(K key) {
		//	int index = getHash(key); 
		//	Hash<K, V> head = storage.get(index);
		//
		//	while (head != null) { 
			//		if (head.key.equals(key)) {
				//			return head.value; 
				//		}
			//		head = head.next; 
			//	}
		//	return null; 
		Hash search = new Hash<K, V>(key, null);
		return storage.contains(search);
	}

	public static void main(String[] args) {
		Map m = new Map();
		m.add("Nishil", 5);
		m.add("Nishil", 6);
		System.out.println(m);
		System.out.println(m.containKey("Pushti"));
		System.out.println(m);
		System.out.println(m.getValue("Nishil"));
		System.out.println(m.getValue("ABCD"));
	}



}
