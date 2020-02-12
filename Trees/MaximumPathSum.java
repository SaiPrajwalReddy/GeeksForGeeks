package Trees;

public class MaximumPathSum {

	static Node root;
	static int result ;

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
		MaximumPathSum tree = new MaximumPathSum();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		tree.findMaxSum(tree.root);
		System.out.println("maximum path sum is : " + result);
	}
	
	private int maximum(int a ,int b)
	{
		if(a > b)
			return a;
		return b;
	}
	private int findMaxSum(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int left = findMaxSum(root.left);
		int right = findMaxSum(root.right);

		int maxSingle = maximum(maximum(left,right)+root.data,root.data);
		
		int maxTop =	maximum(maxSingle,left + right + root.data);
		
		if(maxTop > result)
			result = maxTop;
		
		return maxSingle;
	}
}
