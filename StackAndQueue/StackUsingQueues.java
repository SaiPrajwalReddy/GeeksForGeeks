package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	int currentSize;
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public static void main(String args[]) {
		StackUsingQueues s = new StackUsingQueues();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.remove();
		System.out.println(s.top());
		s.remove();
		System.out.println(s.top());
		System.out.println("current size: " + s.size());
	}

	private int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	private int top() {
		// TODO Auto-generated method stub
		if (q1.isEmpty())
			return 0;

		int x = 0;
		while (!q1.isEmpty()) {
			x = q1.peek();
			q1.poll();
			q2.add(x);
		}

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return x;
	}

	private void remove() {
		// TODO Auto-generated method stub
		if (q1.isEmpty())
			return;

		int x = 0;
		while (!q1.isEmpty()) {
			x = q1.peek();
			q1.poll();
			if (!q1.isEmpty()) {
				q2.add(x);
			}
		}

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		currentSize--;
	}

	private void add(int i) {
		// TODO Auto-generated method stub
		q1.add(i);
		currentSize++;
	}
}
