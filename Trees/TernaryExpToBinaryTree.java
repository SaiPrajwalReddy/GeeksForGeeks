package Trees;

public class TernaryExpToBinaryTree {

	static class Node {
		char data;
		Node left, right;

		public Node(char item) {
			data = item;
			left = null;
			right = null;
		}
	}

	public static void main(String args[]) {
		String exp = "a?b?c:d:e";
		TernaryExpToBinaryTree tree = new TernaryExpToBinaryTree();
		char[] expression = exp.toCharArray();
		Node root = tree.convertExpression(expression, 0);
		tree.printTree(root);
	}

	private void printTree(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}

	private Node convertExpression(char[] expression, int i) {
		// TODO Auto-generated method stub
		if (i >= expression.length)
			return null;
		Node root = new Node(expression[i]);
		if (expression[i] == '?') {
			i++;
			if (i < expression.length)
				root.left = convertExpression(expression, i + 1);

		} else {
			i++;
			if (i < expression.length)
				root.right = convertExpression(expression, i + 1);
		}
		return root;
	}
}
