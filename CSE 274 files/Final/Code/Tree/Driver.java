import java.util.Iterator;


public class Driver {
	public static void main(String args[]){
		BinaryTreeInterface<String> dTree = new BinaryTree<String>();
		dTree.setTree("D", null, null);

		BinaryTreeInterface<String> fTree = new BinaryTree<String>();
		fTree.setTree("F", null, null);

		BinaryTreeInterface<String> gTree = new BinaryTree<String>();
		gTree.setTree("G", null, null);

		BinaryTreeInterface<String> hTree = new BinaryTree<String>();
		hTree.setTree("H", null, null);

		BinaryTreeInterface<String> emptyTree = new BinaryTree<String>();

		// Form larger subtrees
		BinaryTreeInterface<String> eTree = new BinaryTree<String>();
		eTree.setTree("E", fTree, gTree); // Subtree rooted at E

		BinaryTreeInterface<String> bTree = new BinaryTree<String>();
		bTree.setTree("B", dTree, eTree); // Subtree rooted at B

		BinaryTreeInterface<String> cTree = new BinaryTree<String>();
		cTree.setTree("C", emptyTree, hTree); // Subtree rooted at C

		BinaryTreeInterface<String> aTree = new BinaryTree<String>();
		aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

		
		// Display root, height, number of nodes
		System.out.println("Root of tree contains " + aTree.getRootData());
		System.out.println("Height of tree is " + aTree.getHeight());
		System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");

		// Display nodes in inorder
		System.out.println("A Inorder traversal visits nodes in this order:");
		Iterator<String> inorder = aTree.getInorderIterator();
		while (inorder.hasNext())
		   System.out.print(inorder.next() + " ");
		System.out.println();

	}
}
