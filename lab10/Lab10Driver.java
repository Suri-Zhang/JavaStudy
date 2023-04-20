import java.util.Random;

/**
 * 
 * Driver method for Lab 10 - BST
 * 
 * @author john1819
 *
 */
public class Lab10Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a binary tree
		SimpleIntegerBST theTree = new SimpleIntegerBST();

		// let's create a tree with the numbers from 1 to 100 for testing
		for (int i = 50; i <= 100; i++) {
			// start at 50 so tree is more balanced
			theTree.insert(i);
		}
		// now let's go backwards from 49
		for (int i = 49; i > 0; i--) {
			theTree.insert(i);
		}

		// uncomment below to get a random tree
		/*
		 * int tSum = 0; theTree = new SimpleIntegerBST(); Random r = new Random(); for
		 * (int i = 0; i < 100; i++) { int num = r.nextInt(500); theTree.insert(num);
		 * tSum = tSum + num; } System.out.println("The expected sum is : " + tSum);
		 */

		// let's view the tree; in order
	//	theTree.inorder();

		// Now let's find unique things
		// first let's get the sum of all the integers in the tree
		long sum = theTree.findTreeSum();
		// should be 5050
		System.out.println("The sum is " + sum);

		// now let's find the depth
		// should be 51:
		int count = theTree.findTreeHeight();
		System.out.println("The height is  " + count);

	}

}
