package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

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

	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);

		tree.leftView(tree);
	}

	private void leftView(LeftViewOfBinaryTree tree) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();

		Node root = tree.root;

		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {

			Node x = q.peek();
			System.out.print(x.data + " ");

			while (q.peek() != null) {
				Node temp = q.peek();

				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);

				q.poll();
			}

			q.poll();
			if (q.isEmpty())
				break;
			q.add(null);

		}
	}
}
