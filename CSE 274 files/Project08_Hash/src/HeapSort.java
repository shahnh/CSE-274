public class HeapSort 
{ 
	public void sort(Hash arr[]) 
	{ 
		int n = arr.length; 

		// Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i); 

		// One by one extract an element from heap 
		for (int i=n-1; i>=0; i--) 
		{ 
			// Move current root to end 
			Hash temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			// call max heapify on the reduced heap 
			heapify(arr, i, 0); 
		} 
	} 

	// To heapify a subtree rooted with node i which is 
	// an index in arr[]. n is size of heap 
	void heapify(Hash arr[], int n, int i) 
	{ 
		int largest = i; // Initialize largest as root 
		int l = 2*i + 1; // left = 2*i + 1 
		int r = 2*i + 2; // right = 2*i + 2 

		// If left child is larger than root 		
//		if (r < n && arr[r].getValue() == arr[largest].getValue()) {
//			largest = r; 
//		}
//		
//		if (l < n && arr[l].getValue() == arr[largest].getValue()) {
//			largest = l;
//		}
//		
		if (r < n && arr[r].getValue() == arr[largest].getValue()) {
			largest = r; 
		}
			
		
//		if(arr[r].getKey().compareTo(arr[largest].getKey()) == 0) 
//			largest = l;
			
//		if (r < n && arr[r].getValue() < arr[largest].getValue()) 
//			largest = r; 
//		
//		if (l < n && arr[l].getValue() < arr[largest].getValue()) 
//				largest = l; 

		// If right child is larger than largest so far 
//		if (r < n && arr[r].getValue() < arr[largest].getValue()) 
//			largest = r; 

		//        

        // If left child is larger than root 
        if (l < n && arr[l].getValue() < arr[largest].getValue()) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r].getValue() < arr[largest].getValue()) 
            largest = r; 
		
		// If largest is not root 
		if (largest != i) 
		{ 
			Hash swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 

			// Recursively heapify the affected sub-tree 
			heapify(arr, n, largest); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(Hash arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	//    public static void main(String args[]) 
	//    { 
	//        int arr[] = {12, 11, 13, 5, 6, 7}; 
	//        int n = arr.length; 
	//  
	//        HeapSort ob = new HeapSort(); 
	//        ob.sort(arr); 
	//  
	//        System.out.println("Sorted array is"); 
	//        printArray(arr); 
	//    } 
} 

//class Node {
//	private String key;
//	private int value;
//	public Node(String data, int value) {
//		this.key = data;
//		this.value = value;
//	}
//	
//	public String getKey() {
//		return key;
//	}
//	public int getValue() {
//		return value;
//	}
////
////
//	public static Comparator<Node> nodeKeyComp = new Comparator<Node>() {
//	@Override
//	public int compare(Node a, Node b) {
//		return a.getKey().compareToIgnoreCase(b.getKey()); 
//	}
//};
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Node other = (Node) obj;
//		if (key == null) {
//			if (other.key != null)
//				return false;
//		} else if (!key.equals(other.key))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Node [key=" + key + ", value=" + value + "]";
//	}
//	
//}