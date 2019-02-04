import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeJUnitTester {

	public BinaryTree buildBigTree() {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(8);
		BinaryTree left = new BinaryTree();
		left.root = new Node(2);
		left.root.left = new Node(12);
		left.root.left.right = new Node(6);
		left.root.right = new Node(1);
		left.root.right.left = new Node(5);

		BinaryTree right = new BinaryTree();
		right.root = new Node(9);

		tree.root.left = left.root;
		tree.root.right = right.root;

		return tree;
	}

	@Test
	public void testContainsBinaryTree() {
		BinaryTree tree = new BinaryTree();
		assertFalse(tree.contains(20));

		tree.root = new Node(20);
		assertTrue(tree.contains(20));
		assertFalse(tree.contains(25));

		tree.root.left = new Node(40);
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(40));
		assertFalse(tree.contains(25));

		tree.root.right = new Node(10);
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(40));
		assertFalse(tree.contains(25));

		tree.root.right.right = new Node(0);
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(40));
		assertFalse(tree.contains(25));

		tree = buildBigTree();
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(12));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(6));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(9));
		assertFalse(tree.contains(0));
	}

	@Test
	public void testGetHeight() {
		BinaryTree tree = new BinaryTree();
		assertEquals(0, tree.getHeight());

		tree.root = new Node(20);
		assertEquals(1, tree.getHeight());

		tree.root.left = new Node(40);
		assertEquals(2, tree.getHeight());

		tree.root.right = new Node(10);
		assertEquals(2, tree.getHeight());

		tree.root.right.right = new Node(0);
		assertEquals(3, tree.getHeight());

		tree = buildBigTree();
		assertEquals(4, tree.getHeight());
	}

	@Test
	public void testGetNumberOfNodes() {
		BinaryTree tree = new BinaryTree();
		assertEquals(0, tree.getNumberOfNodes());

		tree.root = new Node(20);
		assertEquals(1, tree.getNumberOfNodes());

		tree.root.left = new Node(40);
		assertEquals(2, tree.getNumberOfNodes());

		tree.root.right = new Node(10);
		assertEquals(3, tree.getNumberOfNodes());

		tree.root.right.right = new Node(0);
		assertEquals(4, tree.getNumberOfNodes());

		tree = buildBigTree();
		assertEquals(7, tree.getNumberOfNodes());
	}

	@Test
	public void testGetNumberOfLeaves() {
		BinaryTree tree = new BinaryTree();
		assertEquals(0, tree.getNumberOfLeaves());

		tree.root = new Node(20);
		assertEquals(1, tree.getNumberOfLeaves());

		tree.root.left = new Node(40);
		assertEquals(1, tree.getNumberOfLeaves());

		tree.root.right = new Node(10);
		assertEquals(2, tree.getNumberOfLeaves());

		tree.root.right.right = new Node(0);
		assertEquals(2, tree.getNumberOfLeaves());

		tree = buildBigTree();
		assertEquals(3, tree.getNumberOfLeaves());
	}

	@Test
	public void testIsFull() {
		BinaryTree tree = new BinaryTree();
		assertTrue(tree.isFull());

		tree.root = new Node(20);
		assertTrue(tree.isFull());

		tree.root.left = new Node(40);
		assertFalse(tree.isFull());

		tree.root.right = new Node(10);
		assertTrue(tree.isFull());

		tree.root.right.right = new Node(0);
		assertFalse(tree.isFull());

		tree.root = new Node(20);
		tree.root.left = new Node(15);
		tree.root.right = new Node(16);
		assertTrue(tree.isFull());

		tree.root.right.left = new Node(90);
		tree.root.right.right = new Node(99);
		// Now, both halves are full, but the entire tree is not full
		assertFalse(tree.isFull());

		tree = buildBigTree();
		assertFalse(tree.isFull());
	}


	@Test
	public void testGetMax() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		assertEquals(1, tree.getMax());
		tree.root.data = Integer.MAX_VALUE;
		assertEquals(Integer.MAX_VALUE, tree.getMax());
		tree.root.data = Integer.MIN_VALUE;
		assertEquals(Integer.MIN_VALUE, tree.getMax());

		tree = buildBigTree();
		assertEquals(12, tree.getMax());
	}

	@Test
	public void testTraversals() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.preorderTraversal();
		tree.inorderTraversal();
		tree.postorderTraversal();

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.preorderTraversal();
		tree.inorderTraversal();
		tree.postorderTraversal();

		tree = buildBigTree();
		tree.preorderTraversal();
		tree.inorderTraversal();
		tree.postorderTraversal();
	}

}
