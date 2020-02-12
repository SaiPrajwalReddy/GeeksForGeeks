package DynamicProgramming;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
	}

	private int lcs(char[] x, char[] y, int m, int n) {
		// TODO Auto-generated method stub
		int table[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					table[i][j] = 0;
				else if (x[i - 1] == y[j - 1])
					table[i][j] = table[i - 1][j - 1] + 1;
				else
					table[i][j] = max(table[i - 1][j], table[i][j - 1]);
			}
		return table[m][n];
	}

	private int max(int i, int j) {
		// TODO Auto-generated method stub
		return i > j ? i : j;
	}
}
