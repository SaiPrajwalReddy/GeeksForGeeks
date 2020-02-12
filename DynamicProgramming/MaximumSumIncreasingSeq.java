package DynamicProgramming;

public class MaximumSumIncreasingSeq {

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println("Sum of maximum sum " + "increasing subsequence is " + maxSumIS(arr, n));
	}

	private static int maxSumIS(int[] arr, int n) {

		int temp[] = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++)
			temp[i] = arr[i];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && temp[i] < temp[j] + arr[i])
					temp[i] = temp[j] + arr[i];
			}
		for (int i = 0; i < n; i++)
			if (temp[i] > max) {
				max = temp[i];
			}
		return max;
	}
}
