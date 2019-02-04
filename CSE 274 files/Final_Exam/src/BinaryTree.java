/**
 * A binary tree implementation. When adding values to
 * a tree, there is no assumed "correct" location for that value.
 * So, we will give the root package access, so that we can manually
 * build our trees from a tester class.
 *
 * @author Norm Krumpe
 *
 */
class Node{
	int data;
	Node left, right;

	public Node(int data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(int data){
		this(data, null, null);
	}
}

public class BinaryTree {


	Node root;

	/**
	 * Returns the height of this tree
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node node) {
		if(node == null)
			return 0;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public int getNumberOfNodes() {
		return getNumberOfNodes(root);
	}

	private int getNumberOfNodes (Node node) {
		if(node == null)
			return 0;
		return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right); 
	}

	public int getNumberOfLeaves() {
		return getNumberOfLeaves(root);
	}

	private int getNumberOfLeaves(Node node) {
		if(node == null)
			return 0;
		if(node.right == null && node.left == null)
			return 1;
		return getNumberOfLeaves(node.right) + getNumberOfLeaves(node.left);
	}

	/**
	 * Prints the preorder traversal of this tree
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}

	private void preorderTraversal(Node node) {
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);

	}

	/**
	 * Prints the inorder traversal of this tree
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node node) {
		if(node == null)
			return;
		preorderTraversal(node.left);
		System.out.print(node.data + " ");
		preorderTraversal(node.right);
	}

	/**
	 * Prints the postorder traversal of this tree
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}

	private void postorderTraversal(Node node) {
		if(node == null)
			return;
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		System.out.print(node.data + " ");

	}

	// Returns true if the tree is full,
	// and false otherwise
	public boolean isFull() {
		return Math.pow(2, getHeight()) -1 == getNumberOfNodes();
	}

	// Returns true if the tree contains the value,
	// and false otherwise
	public boolean contains(int value) {
		return contain(root, value);
	}

	private boolean contain(Node node, int value) {
		if(node == null)
			return false;
		if(node.data == value)
			return true;
		return contain(node.left, value) || contain(node.right, value);
	}

	// Returns the largest value in the tree
	public int getMax() {
		return getMax(root, root.data);
		
	}

	private int getMax(Node node, int max) {
		if(node == null)
			return max;
		if(node.data > max)
			return Math.max(getMax(node.left, node.data), getMax(node.right, node.data));
		return Math.max(getMax(node.left, max), getMax(node.right, max));
	}

}