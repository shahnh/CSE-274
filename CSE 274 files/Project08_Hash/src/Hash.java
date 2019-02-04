import java.util.Comparator;

public class Hash {
	String key;
	int value;
	
	Hash next;

	public Hash(String key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hash other = (Hash) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	public static Comparator<Hash> hashValueComp = new Comparator<Hash>() {
	@Override
	public int compare(Hash a, Hash b) {
		return (b.value < a.value ? -1 :                     
			(b.value == a.value ? 0 : 1)); 
	}
};
}
