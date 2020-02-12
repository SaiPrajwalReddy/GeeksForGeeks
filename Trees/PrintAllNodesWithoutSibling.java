package Trees;

public class PrintAllNodesWithoutSibling {

	static Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static void main(String args[]) {
		PrintAllNodesWithoutSibling tree = new PrintAllNodesWithoutSibling();

		/* Let us construct the tree shown in above diagram */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.left.right = new Node(6);
		tree.printSingles(tree.root);
	}

	private void printSingles(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		if (root.left == null && root.right != null) {
			System.out.print(root.right.data + " ");
			printSingles(root.right);
		}

		else if (root.left != null && root.right == null) {
			System.out.print(root.left.data + " ");
			printSingles(root.left);
		} else {
			printSingles(root.left);
			printSingles(root.right);
		}

	}
}
