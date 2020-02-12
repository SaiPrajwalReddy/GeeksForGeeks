package Trees;

public class SumTree {

	static Node root;

	static class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;
		}
	}

	public static void main(String args[]) {

		SumTree tree = new SumTree();
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(3);

		if (tree.isSumTree(tree.root))
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
	}

	private boolean isSumTree(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;

		int left = sum(root.left);
		int right = sum(root.right);

		return (root.data == left + right) && isSumTree(root.left) && isSumTree(root.right);

	}

	private int sum(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		return sum(root.left) + root.data + sum(root.right);

	}

}
