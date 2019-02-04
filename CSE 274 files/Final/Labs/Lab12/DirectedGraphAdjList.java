import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraphAdjList {

	// All the nodes in the graph
	private ArrayList<Node> nodes;
	private int edgeCount;

	/*
	 * Creates a new graph with no nodes.
	 */
	public DirectedGraphAdjList() {
		
	}

	/*
	 * Returns the number of nodes in the graph.
	 */
	public int getNodeCount() {
		return -1;
	}

	/*
	 * Adds a node with a specified name. Returns true iff node is successfully
	 * added, false if it is already in the graph.
	 */
	public boolean addNode(char data) {
		return false;
	}

	/*
	 * Returns true iff a new edge is created from the start node to the end node.
	 */
	public boolean addEdge(char start, char end) {
		return false;
	}

	/*
	 *  Returns true iff start and end are nodes in the graph and there is
	 * an edge from start to end.
	 */
	public boolean hasEdge(char start, char end) {
		return false;
	}

	/*
	 * Performs a breadth-first search, which uses a QUEUE to help keep
	 * track. Returns an empty array if the start location does not exist.
	 */
	public char[] breadthFirstSearch(char start) {
		// A place to store the path
		ArrayList<Node> path = new ArrayList<Node>();

		
		
		

		
		// Returns the path as a char[]
		char[] result = new char[path.size()];
//		for (int i = 0; i < path.size(); i++) {
//			result[i] = path.get(i).label;
//		}
		return result;
	}

	/*
	 * Returns the length of the shortest path from start to end, or
	 * returns -1 if start or end does not exist or if there is no path from start
	 * to end. This essentially performs a breadth-first search until the desired
	 * node has been visited, or until it is determined that the desired node is not
	 * reachable.
	 */
	public int shortestPath(char start, char end) {
		
		return -1;
	}

	
	/*
	 * Gets the number of edges.
	 */
	public int getEdgeCount() {
		return -1;
	}

	/*
	 * Returns true iff the given node specified by label exists.
	 */
	private boolean contains(char label) {
		return false;
	}

	/*
	 * Gets the node with the specified label, or null if the node doesn't exist.
	 */
	private Node getNode(char label) {
		return null;
	}

	/*
	 * A String representation of this graph, listing each node and its neighbors
	 */
	public String toString() {
		String result = "";
		for (Node n : nodes) {
			result = result + n + "\n";
		}
		return result;
	}

	/*
	 * A private Node class. Each node has a label and a collection of neighbors
	 */
	private class Node {
		
		private Node(char label) {
			
		}

		@Override
		public String toString() {
			return null;
		}

		/*
		 * If the node n is not already a neighbor, adds n as a neighbor. Returns true
		 * iff a new neighbor was added.
		 */
		private boolean addNeighbor(Node n) {
			return false;
		}

		/*
		 * Returns true iff this node has n as a neighbor
		 */
		private boolean hasNeighbor(Node n) {
			return false;
		}

		private ArrayList<Node> getNeighbors() {
			return null;
		}

		// Two nodes are equal if they have the same label:
		@Override
		public boolean equals(Object obj) {
			return false;
		}

	}

}
