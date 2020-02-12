package BackTracking;

public class NQueenProblem {
	final int size = 4;

	void printSolution(int board[][]) {
		for (int i = 0; i < 4; i++) {
			System.out.println();
			for (int j = 0; j < 4; j++)
				System.out.print(board[i][j] + " ");
		}
	}

	boolean isSafe(int board[][], int row, int col) {
		for (int i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (int i = row, j = col; i < size && j >= 0; i++, j--)
			if (board[i][j] == 1)
				return false;
		return true;
	}

	/*
	 * A recursive utility function to solve N Queen problem
	 */
	boolean solveNQUtil(int board[][], int col) {
		/*
		 * base case: If all queens are placed then return true
		 */
		if (col >= size)
			return true;
		for (int i = 0; i < size; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				if (solveNQUtil(board, col + 1) == true)
					return true;

				board[i][col] = 0;
			}
		}
		return false;
	}

	boolean solveNQ() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;
	}

	// driver program to test above function
	public static void main(String args[]) {
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQ();
	}
}