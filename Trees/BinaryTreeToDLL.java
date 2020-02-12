package Trees;

public class BinaryTreeToDLL {

	static Node root;
	static Node head;
	static Node prev = null;

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
		// Let us create the tree as shown in above diagram
		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// convert to DLL
		tree.BinaryTree2DoubleLinkedList(tree.root);

		// Print the converted List
		tree.printList(tree.head);

	}

	private void printList(Node head) {
		// TODO Auto-generated method stub
		if (head == null)
			return;
		System.out.print(head.data + " ");
		printList(head.right);
	}

	private void BinaryTree2DoubleLinkedList(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		BinaryTree2DoubleLinkedList(root.left);

		if (head == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		BinaryTree2DoubleLinkedList(root.right);
	}

}
