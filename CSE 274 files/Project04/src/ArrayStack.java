/**
 * @author Nishil Shah
 */
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T>{

	private T[] stack;
	private int numOfEle;
	private final int DEFAULT_CAPACITY = 10;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		stack = (T[]) new Object[DEFAULT_CAPACITY];
		numOfEle = 0;		
	}

	@Override
	public void push(T newEntry) {
		if(numOfEle == stack.length) {
			int newLength = 2 * stack.length;
			stack = Arrays.copyOf(stack, newLength);
		}
		stack[numOfEle] = newEntry;
		numOfEle++;
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T result = stack[numOfEle-1];
			stack[numOfEle-1] = null;
			numOfEle--;
			return result;
		}
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else
			return stack[numOfEle-1];
	}

	@Override
	public boolean isEmpty() {
		return numOfEle == 0;
	}

	@Override
	public void clear() {
		stack = null;
		numOfEle = 0;
	}

}
