package LinkedList;

public class Merge2SortedListsInReverse {

	Node head;
	static Node a, b;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {

		Merge2SortedListsInReverse list = new Merge2SortedListsInReverse();
		Node result = null;

		list.a = new Node(5);
		list.a.next = new Node(10);
		list.a.next.next = new Node(15);

		list.b = new Node(2);
		list.b.next = new Node(3);
		list.b.next.next = new Node(20);

		System.out.println("List a before merge :");
		list.printlist(a);
		System.out.println("");
		System.out.println("List b before merge :");
		list.printlist(b);

		// merge two sorted linkedlist in decreasing order
		result = list.sortedmerge(a, b);
		System.out.println("");
		System.out.println("Merged linked list : ");
		list.printlist(result);

	}

	private void printlist(Node result) {
		// TODO Auto-generated method stub
		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}

	private Node sortedmerge(Node a, Node b) {
		// TODO Auto-generated method stub
		Node temp = new Node(0);
		Node head = null;
		Node front = null;
		Node rear = null;
		Node next = null;
		while (a != null && b != null) {
			if (a.data < b.data) {
				if (head == null) {
					head = a;
					front = a;
				} else {
					temp.next = front;
					front = temp;

				}
				a = a.next;

			} else {
				if (head == null) {
					head = b;
					front = b;
				} else {
					temp.next = front;
					front = temp;

				}
				b = b.next;

			}

		}

		while (a != null) {
			temp.next = front;
			front = temp;
			a = a.next;
		}

		while (b != null) {
			temp.next = front;
			front = temp;
			b = b.next;
		}
		return head;
	}

}
