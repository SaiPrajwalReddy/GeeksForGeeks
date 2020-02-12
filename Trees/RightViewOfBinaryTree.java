package Trees;

public class RightViewOfBinaryTree {

	static Node root;
	static int maxLevel;

	static class Node {

		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static void main(String args[]) {
		RightViewOfBinaryTree tree = new RightViewOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		
		System.out.print(root.data + " ");
		tree.rightView(tree.root, 0);
		

	}

	private void rightView(Node root, int level) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		//System.out.print(root.data+" ");
		if (level > maxLevel) {
			System.out.print(root.data + " ");
			maxLevel = level;
			
		}

		rightView(root.right, level + 1);
		rightView(root.left, level + 1);

	}
}
