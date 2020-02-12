package Trees;

public class ConnectNodesAtSameLevel {
	
	static Node root;
	static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.nextRight = null;
		}
	}
	
	public static void main(String args[])
	{
		 
		ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel(); 
   
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 

        tree.connect(tree.root); 
   
        // Let us check the values of nextRight pointers 
        System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)"); 
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.data + " is "
                + a); 
        int b = tree.root.left.nextRight != null ?  
                                    tree.root.left.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.left.data + " is "
                + b); 
        int c = tree.root.right.nextRight != null ?  
                                   tree.root.right.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.right.data + " is "
                + c); 
        int d = tree.root.left.left.nextRight != null ?  
                              tree.root.left.left.nextRight.data : -1; 
        System.out.println("nextRight of " + tree.root.left.left.data + " is "
                + d);  
	}

	private void connect(Node root) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		
		if(root.left != null)
			root.left.nextRight = root.right;
		
		if(root.right != null)
		{
			if(root.nextRight != null)
				root.right.nextRight = root.nextRight.left;
			else
				root.right.nextRight = null;
		}
	}
}
