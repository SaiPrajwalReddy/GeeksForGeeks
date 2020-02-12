package Trees;

public class CheckForBst {
	
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
		public static void main(String args[])
		{
			CheckForBst tree = new CheckForBst(); 
		        tree.root = new Node(4); 
		        tree.root.left = new Node(2); 
		        tree.root.right = new Node(5); 
		        tree.root.left.left = new Node(1); 
		        tree.root.left.right = new Node(3); 
		        int min = 0;
		        int max = 1000;
		        if (tree.isBST(tree.root,min,max)) 
		            System.out.println("IS BST"); 
		        else
		            System.out.println("Not a BST"); 
		}
		private boolean isBST(Node root, int min, int max) {
			// TODO Auto-generated method stub
			if(root == null)
				return true;
			if(root.data < min || root.data > max)
				return false;
			
			return isBST(root.left,min,root.data-1) && isBST(root.right,root.data+1,max);
			
		}
}
