package Trees;

import Trees.SumTree.Node;

public class SurpasserCount {

	static Node root;

	static class Node {
		int data;
		int surpassCount;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			surpassCount = 0;
			left = right = nextRight = null;
		}
	}

	public static void main(String args[]) {
		int arr[] = { 2, 7, 5, 3, 0, 8, 1 };

		findSurpasser(arr, arr.length);

	}

	private static void findSurpasser(int[] arr, int length) {
		// TODO Auto-generated method stub
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = SurpasserCount.insert(root, arr[i]);
		}

		printTree(root);
	}

	private static void printTree(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.data + " " + root.surpassCount);
		System.out.println();
		printTree(root.right);
	}

	private static Node insert(Node root, int val) {
		// TODO Auto-generated method stub
		if (root == null) {
			Node temp = new Node(val);
			return temp;

		}

		if (root.data > val) {
			root.left = insert(root.left, val);
		} else if (root.data < val) {
			root.surpassCount++;
			root.right = insert(root.right, val);
		}

		return root;
	}

}
