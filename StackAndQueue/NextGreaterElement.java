package StackAndQueue;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String args[]) {

		int arr[] = { 11, 13, 21, 3 }; 
		printNextGtEle(arr);
	}

	private static void printNextGtEle(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			int topElement = s1.peek();
			if (topElement < arr[i]) {
				while (topElement < arr[i]) {
					s1.pop();
					System.out.println("The Next Greater Element for " + topElement + " is " + arr[i]);

					if (s1.isEmpty())
						break;

					topElement = s1.peek();
				}
				s1.push(arr[i]);

			} else {
				s1.push(arr[i]);
			}
		}

		while (!s1.empty()) {
			int topElement = s1.peek();
			s1.pop();
			System.out.println("The Next Greater Element for " + topElement + " is -1");
		}

	}
}
