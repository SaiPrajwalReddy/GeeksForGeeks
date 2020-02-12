package DynamicProgramming;

public class coinChange {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		int n = 4;
		System.out.println(countWays(arr, m, n));
	}

	private static int countWays(int[] arr, int m, int n) {
		int temp[] = new int[n + 1];
		temp[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = arr[i]; j <= n; j++)
				temp[j] += temp[j - arr[i]];
		return temp[n];
	}
}
