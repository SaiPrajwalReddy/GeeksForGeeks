package StackAndQueue;

import java.util.ListIterator;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		System.out.println("Stack elements before sorting: ");
		printStack(s);

		sortStack(s);

	}

	private static void sortStack(Stack<Integer> s) {
		// TODO Auto-generated method stub
		Stack<Integer> temp = new Stack<Integer>();
		temp.push(s.pop());
		while (!s.isEmpty()) {

			int tempVal = temp.peek();
			int stkVal = s.peek();

			if (tempVal < stkVal) {
				temp.push(s.pop());
			} else {
				s.pop();
				while (tempVal > stkVal) {

					s.push(temp.pop());
					if (temp.isEmpty())
						break;
					tempVal = temp.peek();
				}
				temp.push(stkVal);
			}

		}
		System.out.println(" \n\nStack elements after sorting:");
		printStack(temp);
	}

	private static void printStack(Stack<Integer> s) {
		// TODO Auto-generated method stub

		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	}
}
