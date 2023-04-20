

/**
 * A simple BST that is only used to store Integer types. For use with Lab 10.
 * 
 * @author john1819
 *
 */
public class SimpleIntegerBST {

	protected TreeNode<Integer> root;
	protected int size = 0;


	/**
	 * Method to search for a particular integer in the tree
	 *
	 * @param e
	 * @return true if found, false otherwise
	 */
	public boolean search(Integer e) {
		TreeNode<Integer> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else // element matches current.element
				return true; // Element is found
		}

		return false;
	}

	/**
	 * Insert an integer into the tree
	 *
	 * @param e
	 * @return true if inserted, false if already exists
	 */
	public boolean insert(Integer e) {
		if (root == null)
			root = createNewNode(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<Integer> parent = null;
			TreeNode<Integer> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else
					return false; // Duplicate node not inserted
			}
			// Create the new node and attach it to the parent node
			if (e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}

		size++;
		return true; // Element inserted successfully
	}

	/**
	 * Helper method to create a new tree node from an integer
	 *
	 * @param e
	 * @return
	 */
	protected TreeNode<Integer> createNewNode(Integer e) {
		return new TreeNode<Integer>(e);
	}

	/**
	 * Remove a particular integer from the tree
	 *
	 * @param e
	 * @return true if found and deleted.
	 */
	public boolean delete(Integer e) {
		/**
		 * Delete an element from the binary tree. Return true if the element is deleted
		 * successfully Return false if the element is not in the tree
		 */

// Locate the node to be deleted and also locate its parent node
		TreeNode<Integer> parent = null;
		TreeNode<Integer> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed at by current
		}

		if (current == null)
			return false; // Element is not in the tree

// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<Integer> parentOfRightMost = current;
			TreeNode<Integer> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element deleted successfully
	}


	public void inorder() {
		inorder(root);
	}

	/**
	 * In order helper method
	 *
	 * @param root
	 */
	protected void inorder(TreeNode<Integer> root) {
		// prints the tree contents in order
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.element);
		inorder(root.right);

	}


	public int getSize() {

		return size;
	}


	public boolean isEmpty() {

		return size == 0;
	}


	// Lab 10 methods to implement

	/**
	 * Traverses the tree recursively and adds up the value of all the data
	 * in the nodes.
	 *
	 * @return the sum
	 */
	public int findTreeSum() {
		/// implement this method that traverses the tree and returns the sum of all the
		/// nodes - Do NOT modify method header- create additional methods if needed
		return 0;
	}

	private int findTreeSum(TreeNode<Integer> current) {
		int size = 0;
		if (current == null) {
			return 0;
		}
		TreeNode<Integer> present = root;
		//do Some recurring adding
		findTreeSum(present);
		if (current.element.compareTo(present.element) < 0) {
			present = current;
			current = current = current.left;
			size += 1;
		} else if (current.element.compareTo(present.element) > 0) {
			present = current;
			current = current.right;
			size += 1;
		} else {
			return 0;
		}
		if (current.element.compareTo(present.element) < 0) {
			present.left = createNewNode(current.element);
		}

		else {
			present.right = createNewNode(current.element);
		}
			return size;
	}



	public int findTreeHeight() {
		// implement this method that finds the height of the tree (aka depth)
		//  Do NOT modify method header- create additional methods if needed
		return 0;
	}

	
	/**
	 * This inner class is static, because it does not access any instance members
	 * defined in its outer class
	 */
	public static class TreeNode<E extends Comparable<E>> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

}
