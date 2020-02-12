package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomView {

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

	public static void main(String args[]) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		BottomView tree = new BottomView();
		System.out.println("Bottom view of the given binary tree:");
		tree.bottomView(root);
	}

	private void bottomView(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			while (q.peek() != null) {

				Node parent = q.peek();

				if (parent.left != null) {
					parent.left.hd = parent.hd - 1;
					q.add(parent.left);
					if (mp.containsKey(parent.left.hd)) {
						mp.put(parent.left.hd, parent.left.data);
					} else {
						mp.put(parent.left.hd, parent.left.data);
					}
				}

				if (parent.right != null) {
					parent.right.hd = parent.hd + 1;
					q.add(parent.right);
					if (mp.containsKey(parent.right.hd)) {
						mp.put(parent.right.hd, parent.right.data);
					} else {
						mp.put(parent.left.hd, parent.left.data);
					}
				}

				q.poll();
			}

			q.poll();
			if (q.isEmpty())
				break;
			q.add(null);
		}

		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
}
