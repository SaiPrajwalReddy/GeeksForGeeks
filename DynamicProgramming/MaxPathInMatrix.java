package DynamicProgramming;

public class MaxPathInMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		System.out.println("Length of the longest path is " + finLongestOverAll(mat));
	}

	private static int finLongestOverAll(int[][] mat) {
		// TODO Auto-generated method stub
		int dp[][] = new int[3][3];
		int max = 1;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				dp[i][j] = -1;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {

				if (dp[i][j] == -1)
					findPath(mat, dp, i, j);

				if (dp[i][j] > max)
					max = dp[i][j];
			}
		return max;
	}

	private static int findPath(int[][] mat, int[][] dp, int x, int y) {
		// TODO Auto-generated method stub

		if (x < 0 || x >= 3 || y < 0 || y >= 3)
			return 0;

		if (dp[x][y] != -1)
			return dp[x][y];

		int a = 0, b = 0, c = 0, d = 0;

		if (x < 2 && mat[x][y] + 1 == mat[x + 1][y])
			a = dp[x][y] = findPath(mat, dp, x + 1, y) + 1;

		if (y < 2 && mat[x][y] + 1 == mat[x][y + 1])
			b = dp[x][y] = findPath(mat, dp, x, y + 1) + 1;

		if (x > 0 && mat[x][y] + 1 == mat[x - 1][y])
			c = dp[x][y] = findPath(mat, dp, x - 1, y) + 1;

		if (y > 0 && mat[x][y] + 1 == mat[x][y - 1])
			d = dp[x][y] = findPath(mat, dp, x, y - 1) + 1;

		dp[x][y] = Math.max(a, Math.max(b, Math.max(c, Math.max(d, 1))));

		return dp[x][y];
	}

}
