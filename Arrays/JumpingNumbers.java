package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

	public static void main(String[] args) {
		int x = 40;
		JumpingNumbers obj = new JumpingNumbers();
		obj.printJumping(x);
	}

	private void printJumping(int x) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		System.out.print("0 ");
		for (int i = 1; i <= 9; i++)
			q.add(i);
		int num1 = 0, num2 = 0;
		while (!q.isEmpty()) {
			int num = q.peek();
			int last = num % 10;
			q.poll();
			System.out.print(num + " ");

			if (last == 1) {
				num1 = num * 10 + last + 1;
				if (num1 < x)
					q.add(num1);
			} else if (last == 9) {
				num2 = num * 10 + last - 1;
				if (num2 < x)
					q.add(num2);
			}

			else {
				num1 = num * 10 + last + 1;
				num2 = num * 10 + last - 1;
				if (num1 < x)
					q.add(num1);
				if (num2 < x)
					q.add(num2);
			}
		}

	}
}
