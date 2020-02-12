package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrder {

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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println("Vertical Order traversal is");
		printVerticalOrder(root);
	}

	private static void printVerticalOrder(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();

		q.add(root);		
		q.add(null);
		result.add(root.data);
		mp.put(0,result);

		while (!q.isEmpty()) {
			while (q.peek() != null) {

				Node parent = q.peek();

				if (parent.left != null) {
					parent.left.hd = parent.hd - 1;
					q.add(parent.left);
					if (mp.containsKey(parent.left.hd)) {

						result = mp.get(parent.left.hd);
						result.add(parent.left.data);

					} else {

						result = new ArrayList<Integer>();
						result.add(parent.left.data);

					}
					mp.put(parent.left.hd, result);
				}

				if (parent.right != null) {
					parent.right.hd = parent.hd + 1;
					q.add(parent.right);
					if (mp.containsKey(parent.right.hd)) {
						result = mp.get(parent.right.hd);
						result.add(parent.right.data);

					} else {

						result = new ArrayList<Integer>();
						result.add(parent.right.data);
					}

					mp.put(parent.right.hd, result);
				}

				q.poll();
			}

			q.poll();
			if (q.isEmpty())
				break;
			q.add(null);
		}

		for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
			// List<Integer> values = entry.getValue();
			// for (Integer value : values)
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
