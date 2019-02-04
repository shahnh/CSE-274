
public class Hash <K,V>{
	K key;
	V value;
	
	Hash<K,V> next;

	public Hash(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
}
