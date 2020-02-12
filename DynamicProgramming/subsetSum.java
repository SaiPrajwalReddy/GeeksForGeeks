package DynamicProgramming;

public class subsetSum {

	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {
		boolean temp[][] = new boolean[n+1][sum+1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= sum; j++) {

				if (i == 0)
					temp[i][j] = false;
				else if (j == 0)
					temp[i][j] = true;
				else if (set[i - 1] <= j)
					temp[i][j] = temp[i - 1][j] || temp[i - 1][j - set[i - 1]];
				else
					temp[i][j] = temp[i - 1][j];
			}
		return temp[n][sum];
	}
}
