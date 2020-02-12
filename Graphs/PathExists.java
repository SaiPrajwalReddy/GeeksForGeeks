package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PathExists {

	static int rowNum[] = { -1, 0, 0, 1 };
	static int colNum[] = { 0, -1, 1, 0 };

	static class Point {

		public Point(int i, int j) {
			// TODO Auto-generated constructor stub
			x = i;
			y = j;
		}

		int x;
		int y;
	}

	public static void main(String args[]) {
		int M[][] = { { 0, 3, 0, 1 }, { 3, 0, 3, 3 }, { 2, 3, 3, 3 }, { 0, 3, 3, 3 } };

		if (findPath(M, new Point(0, 3), new Point(2, 0)))
			System.out.println("Path Exists");
		else
			System.out.println("Path does not exist");
	}

	private static boolean isSafe(int i, int j) {
		// TODO Auto-generated method stub
		return i >= 0 && i < 4 && j >= 0 && j < 4;
	}

	private static boolean findPath(int[][] m, Point source, Point dest) {
		// TODO Auto-generated method stub
		boolean visited[][] = new boolean[4][4];
		Queue<Point> q = new LinkedList<Point>();
		q.add(source);

		while (!q.isEmpty()) {
			Point p = q.peek();
			if (m[p.x][p.y] == 2)
				return true;
			q.poll();
			for (int k = 0; k < 4; k++) {
				int newX = rowNum[k] + p.x;
				int newY = colNum[k] + p.y;
				if (isSafe(newX, newY) && !visited[newX][newY] && (m[newX][newY] == 3 || m[newX][newY] == 2)) {

					visited[newX][newY] = true;
					q.add(new Point(newX, newY));
				}

			}

		}
		return false;
	}
}
