/*package LinkedList;

import LinkedList.LinkedList.Node;

class LinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void printList(Node head2) {
		// TODO Auto-generated method stub

		Node temp = head2;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	public void detectAndRemoveLoop(Node head2) {
		// TODO Auto-generated method stub
		Node slow = head2;
		Node fast = head2;		
		while (fast.next != null && slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				removeLoop(slow, head2);
				break;
			}
		}
	}

	private void removeLoop(Node slow, Node head) {
		// TODO Auto-generated method stub
		Node temp1 = slow;
		Node temp2 = head;

		while (temp1.next != temp2.next) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		temp1.next = null;

	}
}

public class RemoveLoop {

	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		list.head.next.next.next.next.next = list.head.next.next;
		list.detectAndRemoveLoop(list.head);
		System.out.println("Linked List after removing loop : ");
		list.printList(list.head);
	}
}
*/