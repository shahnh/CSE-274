/**
 * @author Nishil Shah
 * 8-28-2018
 * CSE 274 F
 * Lab 1
 */
public class IntegerContainer implements ContainerInterface<Integer> {

	public static final int MAX_SIZE = 10;
	private Integer arr[] = new Integer[MAX_SIZE];
	private int curSize = 0;

	@Override
	public int size() {
		return curSize;
	}

	@Override
	public boolean isEmpty() {
		if (curSize == 0)
			return true;
		return false;
	}

	@Override
	public int indexOf(Integer anObject) {
		for (int i = 0; i < curSize; i++) {
			if (arr[i].equals(anObject))
				return i;
		}
		return -1;
	}

	@Override
	public boolean add(Integer newObject) {
		if (curSize >= MAX_SIZE)
			return false;

		arr[curSize] = newObject;
		curSize++;
		return true;
	}

	@Override
	public boolean remove(Integer anObject) {

		int contains = 0;
		for (int i = 0; i < curSize; i++) {
			if (anObject == arr[i]) {
				contains++;
				for(int j = i; j < curSize; j++)
					arr[i] = arr[i + 1];
				i--;
			}
		}

		if (contains != 0) {
			curSize -= contains;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Integer anObject) {
		for(int i = 0; i<curSize; i++) {
			if(arr[i] == anObject)
				return true;
		}
		return false;
	}

}
