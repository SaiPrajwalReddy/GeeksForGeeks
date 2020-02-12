package Trees;

public class LCAinBST {
	static Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String args[]) {
		LCAinBST tree = new LCAinBST();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	}

	private Node lca(Node root, int n1, int n2) {
		// TODO Auto-generated method stub
		if(root == null )
			return null;
		if(root.data > n1 && root.data < n2)
			return root;
		if(root.data > n1 && root.data > n2)
			return lca(root.left,n1,n2);
		
		if(root.data < n1 && root.data < n2)
			return lca(root.right,n1,n2);
		
		return root;
	}
}
