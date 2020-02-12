package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
	int data;
	Node next;
	static Node head;
	static Node last;
	Node(int data) {
		this.data = data;
		next = null;
	}
}

class nodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return o1.data-o2.data;
	}
	
}
public class MergeKSortedLinkedLists {

	public static void main(String args[]) {
		int k = 3;
		int n = 4;

		Node arr[] = new Node[k];

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		Node head = mergeKSortedLists(arr, k);
		printList(head);
	}

	private static void printList(Node head) {
		// TODO Auto-generated method stub
		while(head != null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	private static Node mergeKSortedLists(Node[] arr, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new nodeComparator());

		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		
		while(!pq.isEmpty())
		{
			Node temp = pq.peek();
			
			if(Node.head == null)
			{
				Node.head = temp;
				Node.last = temp;
			}
			else
			{
				Node.last.next = temp;
				Node.last = temp;			
			}
			if(temp.next !=null)
			{
				pq.add(temp.next);
			}
			pq.poll();
		}
		return Node.head;
	}
}
