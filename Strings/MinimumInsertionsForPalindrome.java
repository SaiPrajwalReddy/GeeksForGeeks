package Strings;

public class MinimumInsertionsForPalindrome {

	public static void main(String args[]) {
		String str = "aa";
		int len = lengthOfSubsequence(str);
		System.out.println("Minimum No of insertions needed is " + (str.length() - len));
	}

	private static int lengthOfSubsequence(String str) {
		// TODO Auto-generated method stub
		StringBuilder revStr = new StringBuilder(str);
		revStr = revStr.reverse();
		int dp[][] = new int[str.length() + 1][revStr.length() + 1];

		for (int i = 0; i <= str.length(); i++) {
			for (int j = 0; j <= revStr.length(); j++) {

				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (str.charAt(i - 1) == revStr.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {

					if (dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		return dp[str.length()][revStr.length()];

	}
}
