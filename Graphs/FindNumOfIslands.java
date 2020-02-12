package Graphs;

public class FindNumOfIslands {

	public static void main(String[] args) throws java.lang.Exception {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		FindNumOfIslands I = new FindNumOfIslands();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}

	private int countIslands(int[][] m) {
		// TODO Auto-generated method stub
		boolean visited[][] = new boolean[5][5];
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		int count = 0;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {

				if (m[i][j] == 1 && !visited[i][j]) {
					DFS(m, visited, rowNbr, colNbr, i, j);
					count++;
				}
			}

		return count;
	}

	private void DFS(int[][] m, boolean[][] visited, int[] rowNbr, int[] colNbr, int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafe(rowNbr[k] + x, colNbr[k] + y) && !visited[rowNbr[k] + x][colNbr[k] + y]
					&& m[rowNbr[k] + x][colNbr[k] + y] == 1) {
				DFS(m, visited, rowNbr, colNbr, rowNbr[k] + x, colNbr[k] + y);
			}
		}
	}

	private boolean isSafe(int i, int j) {
		// TODO Auto-generated method stub
		return i >= 0 && i < 5 && j >= 0 && j < 5;
	}
}
