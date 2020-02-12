package Trees;

import java.util.Stack;

public class SpiralOrderTraversal {

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
		SpiralOrderTraversal tree = new SpiralOrderTraversal(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(6); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(4); 
        System.out.println("Spiral order traversal of Binary Tree is "); 
        tree.printSpiral(tree.root); 
	}

	private void printSpiral(Node root) {
		// TODO Auto-generated method stub
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
						
			while(!s1.isEmpty())
			{
				Node temp = s1.peek();
				
				if(temp.right!=null)
					s2.push(temp.right);
				if(temp.left!=null)
					s2.push(temp.left);
			
				
				System.out.print(temp.data+" ");
				s1.pop();
			}
			
			while(!s2.isEmpty())
			{
				Node temp = s2.peek();
				
				if(temp.left!=null)
					s1.push(temp.left);
				if(temp.right!=null)
					s1.push(temp.right);
			
				
				System.out.print(temp.data+" ");
				s2.pop();
			}
		}
		
	}
}
