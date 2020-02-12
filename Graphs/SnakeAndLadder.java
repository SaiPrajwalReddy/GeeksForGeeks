package Graphs;

import java.util.LinkedList;
import java.util.Queue;

import Graphs.ShortestSourceToDest.Point;

public class SnakeAndLadder {
	static class Point {
		public Point(int newPos, int i) {
			vertex = newPos;
			dist = i;
		}

		int vertex;
		int dist;
	}

	public static void main(String[] args) {
		// Let us construct the board given in above diagram
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

	private static int getMinDiceThrows(int[] moves, int n) {
		// TODO Auto-generated method stub
		return BFS(moves, new Point(0, 0), n);

	}

	private static int BFS(int[] moves, Point src, int n) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[30];
		Queue<Point> q = new LinkedList<Point>();
		q.add(src);
		visited[0] = true;

		while (!q.isEmpty()) {
			Point curr = q.peek();
			int currPos = curr.vertex;
			int currDist = curr.dist;
			if (currPos == n - 1)
				return currDist;
			q.poll();
			for (int k = 1; k <= 6; k++) {
				int newPos = k + currPos;
				if (newPos >= n)
					continue;
				if (!visited[newPos]) {

					if (moves[newPos] != -1) {
						newPos = moves[newPos];
					}

					visited[newPos] = true;
					q.add(new Point(newPos, currDist + 1));
				}

			}

		}
		return 0;
	}
}
