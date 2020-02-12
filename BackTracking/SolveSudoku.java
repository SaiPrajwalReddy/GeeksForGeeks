package BackTracking;

public class SolveSudoku {
	static int row;
	static int col;

	public static void main(String args[]) {

		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int N = board.length;

		if (solveSudoku(board, N)) {
			print(board, N); // print solution
		} else {
			System.out.println("No solution");
		}
	}

	private static boolean solveSudoku(int[][] board, int n) {
		// TODO Auto-generated method stub

		if (solveSudokuUtil(board, n))
			return true;
		return false;
	}

	private static boolean solveSudokuUtil(int[][] board, int n) {
		// TODO Auto-generated method stub
		if (!findUnassignedPos(board, n)) {
			print(board, n);
			return true;
		}

		for (int k = 1; k <= 9; k++) {
			if (isSafe(board, n, row, col, k)) {
				board[row][col] = k;
				if (solveSudokuUtil(board, n))
					return true;
				board[row][col] = 0;
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] board, int n, int row, int col, int val) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++)
			if (board[row][i] == val)
				return false;

		for (int i = 0; i < n; i++)
			if (board[i][col] == val)
				return false;
		int rowStart = row - row % 3;
		int colStart = col - col % 3;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[rowStart + i][colStart + j] == val)
					return false;
		return true;
	}

	private static void print(int[][] board, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++)
				System.out.print(board[i][j] + " ");
		}

	}

	private static boolean findUnassignedPos(int[][] board, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					return false;
				}
			}
		return true;
	}
}
