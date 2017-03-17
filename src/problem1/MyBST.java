package problem1;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	private BinaryNode root;

	public MyBST() {
		root = null;
	}

	/**
	 * Prints the values in the nodes of the tree in sorted order. Inorder
	 * Traversal
	 */
	public void printTree() {
		if (root == null)
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	// Inorder Traversal to print the nodes in Ascending order
	private void printTree(BinaryNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.print(t.element + ",");
			printTree(t.right);
		}
	}

	// Assume the data in the Node is an Integer.

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			return;
		} else {
			BinaryNode n = root;
			boolean inserted = false;

			while (!inserted)// true
			{
				if (x.compareTo(n.element) < 0) {
					// space found on the left
					if (n.left == null) {
						n.left = new BinaryNode(x, null, null);
						inserted = true;
					}
					// keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				} else if (x.compareTo(n.element) > 0) {
					// space found on the right
					if (n.right == null) {
						n.right = new BinaryNode(x, null, null);
						inserted = true;
					}
					// keep looking for a place to insert (a null)
					else {
						n = n.right;
					}

				}
				// if a node already exists
				else {
					inserted = true;
				}

			}

		}
	}

	// Implement

	public void preOrder() {
		if (root == null)
			System.out.println("Empty tree");
		else
			preOrder(root);
	}

	private void preOrder(BinaryNode t) {// implement
		if (t != null) {
			System.out.println(t.element + ",");
			preOrder(t.left);
			preOrder(t.right);
		}
	}

	public void postOrder() {
		if (root == null)
			System.out.println("Empty tree");
		else
			postOrder(root);
	}

	private void postOrder(BinaryNode t) { // implement
		if (t != null) {
			postOrder(t.left);
			postOrder(t.right);
			System.out.println(t.element + ",");
		}
	}

	public boolean contains(Integer key) {
		if (root == null)
			return false;
		return contains(key, root);
	}

	private boolean contains(Integer key, BinaryNode t) { // implement }
		if (t == null)
			return false;
		boolean isContains = false;
		if (t.left != null) {
			if (key.compareTo(t.left.element) != 0)
				isContains = contains(key, t.left);
			else
				return true;
		}
		if (t.right != null) {
			if (key.compareTo(t.right.element) != 0)
				isContains = contains(key, t.right);
			else
				return true;
		}
		return isContains;
	}

	public Integer getRoot() {// implement }
		if (root == null) {
			System.out.print("Tree is empty. ");
			return -1;
		}
		return root.element;
	}

	public Integer leafNodes() {
		return leafNodes(root);
	}

	private int leafNodes(BinaryNode t) {// Implement}
		int countleaf = 0;
		if (t != null) {
			if (t.left == null && t.right == null) {
				return 1;
			}
			if (t.left != null) {
				countleaf += leafNodes(t.left);
			}
			if (t.right != null) {
				countleaf += leafNodes(t.right);
			}
		}
		return countleaf;
	}

	public int size() {
		if (root == null)
			return 0;
		return size(root);
	}

	private int size(BinaryNode t) {// implement }
		if (t == null)
			return 0;
		return size(t.left) + size(t.right) + 1;
	}

	public boolean isEmpty() {// implement } // check the tree is empty or not
		if (root == null)
			return true;
		return false;
	}

	public Integer findMin() {
		if (root == null)
			return 0;
		return findMin(root, root.element);
	}

	private Integer findMin(BinaryNode t, Integer min) {// implement }
		if (t == null)
			return 0;
		if (t.left != null) {
			if (min.compareTo(t.left.element) > 0)
				min = t.left.element;
			return findMin(t.left, min);
		}
		return min;
	}

	public Integer findMax() {
		if (root == null)
			return 0;
		return findMax(root, root.element);
	}

	public Integer findMax(BinaryNode t, Integer max) {// implement }
		if(t==null)
			return 0;
		if (t.right != null) {
			if (max.compareTo(t.right.element) < 0)
				max = t.right.element;
			return findMax(t.right, max);
		}
		return max;
	}

	private class BinaryNode {

		private Integer element;// The data in the node
		private BinaryNode left; // Left child
		private BinaryNode right; // Right child
		// Constructors

		BinaryNode(Integer theElement) {
			this(theElement, null, null);
		}

		BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}

	}

	public static void main(String[] args) {

		MyBST mybst = new MyBST();
		System.out.println("Is empty: "+mybst.isEmpty());

		int[] a = { 15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25 };

		for (int j = 0; j < a.length; j++) {
			mybst.insert(a[j]);

		}
		mybst.insert(12);
		mybst.printTree();

		TreeSet<Integer> ts = new TreeSet<Integer>();

		for (int j = 0; j < a.length; j++) {
			ts.add(a[j]);
			System.out.println("\nAfter inserting " + j + "th item " + a[j]);
			Iterator<Integer> it = ts.iterator();
			Integer nextItem = null;
			while (it.hasNext()) {
				nextItem = it.next();
				System.out.print(nextItem + " ");
			}
			System.out.println();
		}

		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(8, "Hello");
		map.put(10, "World!");
		map.put(11, "Welcome");
		map.remove(8);
		String str = map.get(11) + ", " + map.get(10);
		System.out.println(str);
		System.out.println("Is empty: "+mybst.isEmpty());
		System.out.println("Test Leaf Nodes: " + mybst.leafNodes());
		System.out.println("Does tree contain 12? "+mybst.contains(12));
		System.out.println("Does tree contain 121? "+mybst.contains(121));
		System.out.println("Size: "+mybst.size());
		System.out.println("Min: " + mybst.findMin());
		System.out.println("Max: " + mybst.findMax());
	}
}
