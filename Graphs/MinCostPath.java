package Graphs;

public class MinCostPath {

	public static void main(String args[]) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.print(minCost(cost, 2, 2));
	}

	private static int minCost(int[][] cost, int m, int n) {
		// TODO Auto-generated method stub
		int table[][] = new int[m + 1][n + 1];
		table[0][0] = cost[0][0];
		for (int j = 1; j <= n; j++)
			table[0][j] = table[0][j - 1] + cost[0][j];

		for (int i = 1; i <= m; i++)
			table[i][0] = table[i - 1][0] + cost[i][0];

		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {

				table[i][j] = min(table[i - 1][j], table[i][j - 1], table[i - 1][j - 1])+cost[i][j];
			}
		return table[m][n];
	}

	private static int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i < j && i < k)
			return i;
		else if (j < i && j < k)
			return j;
		return k;
	}
}
