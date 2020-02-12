package Trees;

public class RootToLeafPath {

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
		int sum = 21;

		RootToLeafPath tree = new RootToLeafPath();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);

		if (tree.haspathSum(tree.root, sum, 0))
			System.out.println("There is a root to leaf path with sum " + sum);
		else
			System.out.println("There is no root to leaf path with sum " + sum);
	}

	private boolean haspathSum(Node root, int sum, int k) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;
		k = k + root.data;
		if (root.left == null && root.right == null)
			if (k == sum)
				return true;
		return haspathSum(root.left, sum, k) || haspathSum(root.right, sum, k);

	}
}
