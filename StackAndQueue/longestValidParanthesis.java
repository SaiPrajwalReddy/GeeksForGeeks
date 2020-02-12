package StackAndQueue;

import java.util.Stack;

public class longestValidParanthesis {

	public static void main(String[] args) {
		String str = "((()()";
		System.out.println(findMaxLen(str));

		str = "()(()))))";
		System.out.println(findMaxLen(str));

	}

	private static int findMaxLen(String str) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		int max = 0;
		s.push(-1);
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(')
				s.push(i);
			else {
				s.pop();
				if (s.isEmpty())
					s.push(i);
				else {
					Integer index = s.peek();
					if (i - index > max)
						max = i - index;

					
				}
			}
		}
		return max;
	}
}
