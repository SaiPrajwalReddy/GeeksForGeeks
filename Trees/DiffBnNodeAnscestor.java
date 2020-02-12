package Trees;

public class DiffBnNodeAnscestor {
	static Node root;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		DiffBnNodeAnscestor tree = new DiffBnNodeAnscestor();

		// Making above given diagram's binary tree
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(7);

		tree.root.right = new Node(10);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);
		 tree.maxDiff(tree.root);
		System.out.println("Maximum difference between a node and" + " its ancestor is : " + max);
	}

	private int maxDiff(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return Integer.MAX_VALUE;
		;

		if (root.left == null && root.right == null)
			return root.key;

		// int min = maxDiffFromCurrentNode(root);
		int left = maxDiff(root.left);
		int right = maxDiff(root.right);
		// System.out.println(min);
		int min = left < right ? left : right;

		if (root.key - min > max)
			max = root.key - min;

		return min < root.key ? min : root.key;
	}

	private int maxDiffFromCurrentNode(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return Integer.MAX_VALUE;
		maxDiffFromCurrentNode(root.left);
		if (root.key < min)
			min = root.key;
		maxDiffFromCurrentNode(root.right);

		return min;

	}
}
