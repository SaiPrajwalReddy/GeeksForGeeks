package Trees;

public class LcaInBinaryTree {

	static Node root;

	static class Node {
		int data;
		int hd;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.hd = 0;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		LcaInBinaryTree tree = new LcaInBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5): " + tree.findLCA(4, 5, tree.root).data);
		System.out.println("LCA(4, 6): " + tree.findLCA(4, 6, tree.root).data);
		System.out.println("LCA(3, 4): " + tree.findLCA(3, 4, tree.root).data);
		System.out.println("LCA(2, 4): " + tree.findLCA(2, 4, tree.root).data);

	}

	private Node findLCA(int i, int j, Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;

		if (root.data == i || root.data == j)
			return root;
		Node left = findLCA(i, j, root.left);
		Node right = findLCA(i, j, root.right);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
}
