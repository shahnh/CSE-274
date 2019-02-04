import java.util.Arrays;

public class ArrayQueue<T> implements QueueInterface<T>{

	private int frontIndex, backIndex, numOfElement;
	private T[] queue;
	public static final int DEFAULT_SIZE = 2;
	
	
	public ArrayQueue() {
		queue = (T[]) new Object[DEFAULT_SIZE];
		numOfElement = 0;
		frontIndex = 0;
		backIndex = -1;
	}
	
	@Override
	public void enqueue(T newEntry) {
		if(numOfElement == queue.length) {
			T[] temp = (T[]) new Object[queue.length * 2];
			for(int i = 0; i < numOfElement; i++) {
				temp[i] = queue[(frontIndex+i) % numOfElement];
			}
			queue = temp;
			frontIndex = 0;
			backIndex = numOfElement -1;
		}
		backIndex = (backIndex+1) % queue.length;
		queue[backIndex] = newEntry;
		numOfElement++;
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new EmptyQueueException();
		T returns = queue[frontIndex];
		queue[frontIndex] = null;
		frontIndex = (frontIndex + 1) % queue.length;
		numOfElement--;
		return returns;
	}

	@Override
	public T getFront() {
		return queue[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		return numOfElement == 0;
	}

	@Override
	public void clear() {
		queue = null;
		numOfElement = 0;
		frontIndex = 0;
		backIndex = -1;
	}

}
