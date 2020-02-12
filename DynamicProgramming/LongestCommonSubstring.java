package DynamicProgramming;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		String X = "OldSite:GeeksforGeeks.org";
		String Y = "NewSite:GeeksQuiz.com";

		int m = X.length();
		int n = Y.length();

		System.out.println("Length of Longest Common Substring is " + longComSubString(X, Y, m, n));
	}

	private static int longComSubString(String x, String y, int m, int n) {
		// TODO Auto-generated method stub
		int table[][] = new int[m + 1][n + 1];
		int max = 0;

		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					table[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					{
					table[i][j] = table[i - 1][j - 1] + 1;
					if(table[i][j] > max)
						max = table[i][j];
					}
				else
					table[i][j] = 0;
			}
		return max;
	}
}
