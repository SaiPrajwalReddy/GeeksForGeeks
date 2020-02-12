package LinkedList;

import LinkedList.linkedlistATN.Node;

class linkedlistATN {

	Node head;
	static int carry = 0;
	static Node result;
	private static Node currentNode;

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	@SuppressWarnings("static-access")
	static void addTwoNum(linkedlistATN list1, linkedlistATN list2) {
		// TODO Auto-generated method stub
		Node temp;
		int size1 = getSize(list1);
		int size2 = getSize(list2);
		int diff = Math.abs(size1 - size2);
		Node temp1 = list1.head;
		Node temp2 = list2.head;

		System.out.println(size1 + " " + size2);
		if (size1 < size2) {
			temp = list1.head;
			list1.head = list2.head;
			list2.head = temp;
		}

		for (int i = 0; i < diff; i++) {
			temp1 = temp1.next;
		}
		currentNode = temp1;
		addNum(temp1, temp2);
		if (carry == 1)
			propogateCarry(list1.head);

		if (carry > 0) {
			appendToResult(carry);
		}
	}

	private static void propogateCarry(Node temp1) {
		// TODO Auto-generated method stub

		if (temp1 == currentNode)
			return;
		propogateCarry(temp1.next);
		int sum = carry + temp1.data;
		carry = sum / 10;
		sum = sum % 10;
		appendToResult(sum);

	}

	private static void addNum(Node temp1, Node temp2) {
		// TODO Auto-generated method stub
		if (temp1 == null)
			return;

		addNum(temp1.next, temp2.next);

		int sum = temp1.data + temp2.data + carry;
		carry = sum / 10;

		appendToResult(sum % 10);

	}

	private static void appendToResult(int i) {
		// TODO Auto-generated method stub
		Node temp = result;
		result = new Node(i);
		result.next = temp;

	}

	@SuppressWarnings("static-access")
	private static int getSize(linkedlistATN list) {
		// TODO Auto-generated method stub
		Node temp = list.head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;

		}
		return count;
	}

	public static void printList() {
		// TODO Auto-generated method stub
		Node temp = result;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}
}

public class Add2Numbers {

	@SuppressWarnings("static-access")
	public static void main(String args[]) {

		linkedlistATN list1 = new linkedlistATN();
		linkedlistATN list2 = new linkedlistATN();

		list1.head = new Node(6);
		list1.head.next = new Node(4);
		list1.head.next.next = new Node(9);
		list1.head.next.next.next = new Node(7);
		list1.head.next.next.next.next = new Node(5);

		list2.head = new Node(4);
		list2.head.next = new Node(8);

		linkedlistATN.addTwoNum(list1, list2);
		linkedlistATN.printList();

	}

}
