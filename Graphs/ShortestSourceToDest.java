package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestSourceToDest {

	static class Point {

		public Point(int i, int j, int k) {
			// TODO Auto-generated constructor stub
			x = i;
			y = j;
			dist = k;
		}

		int x;
		int y;
		int dist;
	}

	static int rowNum[] = { -1, 0, 0, 1 };
	static int colNum[] = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		Point source = new Point(0, 0, 0);

		Point dest = new Point(3, 4, -1);

		int dist = BFS(mat, source, dest);

		if (dist != Integer.MAX_VALUE)
			System.out.println("Shortest Path is " + dist);
		else
			System.out.println("Shortest Path doesn't exist");
	}

	private static boolean isSafe(int i, int j) {
		// TODO Auto-generated method stub
		return i >= 0 && i < 5 && j >= 0 && j < 5;
	}

	private static int BFS(int[][] mat, Point source, Point dest) {
		// TODO Auto-generated method stub
		boolean visited[][] = new boolean[9][10];
		Queue<Point> q = new LinkedList<Point>();
		q.add(source);

		while (!q.isEmpty()) {
			Point p = q.peek();
			if (p.x == dest.x && p.y == dest.y)
				return p.dist;
			q.poll();
			for (int k = 0; k < 4; k++) {
				int newX = rowNum[k] + p.x;
				int newY = colNum[k] + p.y;
				if (isSafe(newX, newY) && !visited[newX][newY] && mat[newX][newY] == 1) {

					visited[newX][newY] = true;
					q.add(new Point(newX, newY,p.dist+1));
				}

			}

		}
		return 0;
	}

}
