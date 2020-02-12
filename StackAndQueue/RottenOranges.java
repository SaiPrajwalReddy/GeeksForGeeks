package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	static class Node {
		int row;
		int column;
	}

	public static void main(String args[]) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr);
		System.out.println(ans);
	}

	private static int rotOranges(int[][] arr) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		Node n = null;
		boolean updated = false;
		int answer = 0;
		boolean exists = true;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == 2) {
					n = new Node();
					n.row = i;
					n.column = j;
					q.add(n);
				}
			}
		n = new Node();
		n.row = -1;
		n.column = -1;
		q.add(n);

		while (!q.isEmpty()) {
			while (!delimiter(q)) {
				Node temp = q.peek();
				Node temp1 = null;
				if (isValid(temp.row, temp.column + 1) && arr[temp.row][temp.column + 1] == 1) {
					if (!updated) {
						answer++;
						updated = true;
					}

					arr[temp.row][temp.column + 1] = 2;
					temp1 = new Node();
					temp1.row = temp.row;
					temp1.column = temp.column + 1;
					q.add(temp1);
				}

				if (isValid(temp.row, temp.column - 1) && arr[temp.row][temp.column - 1] == 1) {
					if (!updated) {
						answer++;
						updated = true;
					}

					arr[temp.row][temp.column - 1] = 2;
					temp1 = new Node();
					temp1.row = temp.row;
					temp1.column = temp.column - 1;
					q.add(temp1);
				}

				if (isValid(temp.row + 1, temp.column) && arr[temp.row + 1][temp.column] == 1) {
					if (!updated) {
						answer++;
						updated = true;
					}

					arr[temp.row + 1][temp.column] = 2;
					temp1 = new Node();
					temp1.row = temp.row + 1;
					temp1.column = temp.column;
					q.add(temp1);
				}

				if (isValid(temp.row - 1, temp.column) && arr[temp.row - 1][temp.column] == 1) {
					if (!updated) {
						answer++;
						updated = true;
					}

					arr[temp.row - 1][temp.column] = 2;
					temp1 = new Node();
					temp1.row = temp.row - 1;
					temp1.column = temp.column;
					q.add(temp1);
				}
				q.poll();
			}
			updated = false;
			q.poll();
			if (q.isEmpty())
				break;
			n = new Node();
			n.row = -1;
			n.column = -1;
			q.add(n);

		}

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == 1) {
					exists = false;
					break;
				}
			}

		if (exists)
			return answer;
		return -1;
	}

	private static boolean isValid(int row, int column) {
		// TODO Auto-generated method stub
		return (row >= 0 && row < 3 && column >= 0 && column < 5);
	}

	private static boolean delimiter(Queue<Node> q) {
		// TODO Auto-generated method stub
		Node temp = q.peek();
		return (temp.row == -1 && temp.column == -1);

	}
}
