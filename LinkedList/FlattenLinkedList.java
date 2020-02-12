package LinkedList;

class linkedList {
	static Node head;

	class Node {

		int data;
		Node right;
		Node down;

		Node(int data) {
			this.data = data;
			this.right = null;
			this.down = null;
		}
	}

	public void printList() {
		// TODO Auto-generated method stub
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.down;

		}

	}

	public Node flatten(Node head2) {
		// TODO Auto-generated method stub
		Node head = head2;
		while (head2 != null && head2.right != null) {			
			head = merge(head, head2.right);
			head2 = head2.right;
		}
		return head;
	}

	private Node merge(Node head1, Node head2) {
		// TODO Auto-generated method stub
		Node result = null;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.data < head2.data) {
			result = head1;
			result.down = merge(head1.down, head2);
		} else {
			result = head2;
			result.down = merge(head1, head2.down);
		}
		return result;
	}

	Node push(Node head_ref, int data) {

		Node new_node = new Node(data);
		new_node.down = head_ref;
		head_ref = new_node;
		return head_ref;
	}
}

public class FlattenLinkedList {

	@SuppressWarnings("static-access")
	public static void main(String args[]) {

		linkedList L = new linkedList();

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.right = L.push(L.head.right, 20);
		L.head.right = L.push(L.head.right, 10);

		L.head.right.right = L.push(L.head.right.right, 50);
		L.head.right.right = L.push(L.head.right.right, 22);
		L.head.right.right = L.push(L.head.right.right, 19);

		L.head.right.right.right = L.push(L.head.right.right.right, 45);
		L.head.right.right.right = L.push(L.head.right.right.right, 40);
		L.head.right.right.right = L.push(L.head.right.right.right, 35);
		L.head.right.right.right = L.push(L.head.right.right.right, 20);

		// flatten the list
		L.head = L.flatten(L.head);

		L.printList();

	}

}
